package com.mayoristas.interfaz_contable.shared.infrastructure.config;

import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.Objects;

/**
 * {@code DataAccessErrorClassifier} clasifica errores de acceso a datos y conectividad
 * a base de datos a partir de excepciones de Spring {@link DataAccessException}.
 *
 * <p>
 * La clasificación se realiza inspeccionando la causa raíz, el tipo de excepción,
 * posibles {@link SQLException} asociadas (SQLState) y mensajes de error.
 * </p>
 *
 * <p>
 * Retorna un código lógico reutilizable por capas superiores para normalización de logs
 * y respuestas de error.
 * </p>
 *
 * @since 1.1
 */
public final class DataAccessErrorClassifier {

    private DataAccessErrorClassifier() {
    }

    /**
     * Clasifica una excepción de acceso a datos en un código lógico de error.
     *
     * @param ex excepción de acceso a datos.
     * @return código lógico de error.
     * @throws NullPointerException si {@code ex} es {@code null}.
     */
    public static String classify(DataAccessException ex) {
        Objects.requireNonNull(ex, "DataAccessException no puede ser null");

        //Clasificación por tipo
        String type = ex.getClass().getSimpleName().toLowerCase();
        if (containsAny(type, "querytimeout", "timeout")) {
            return "timeout";
        }
        if (containsAny(type, "cannotgetjdbcconnection", "dataaccessresourcefailure", "transientdataaccessresource")) {
            return "sin_conexion_o_db_caida";
        }

        //Clasificación por causa raíz / SQLException
        Throwable root = getRootCause(ex);

        if (root instanceof SQLException sqlEx) {
            String state = sqlEx.getSQLState();
            String msg = safeLower(sqlEx.getMessage());

            // timeouts
            if (containsAny(msg, "timeout", "timed out", "read timed out", "query timed out", "statement timeout")) {
                return "timeout";
            }

            // autenticación (PostgreSQL)
            if ("28P01".equals(state) || containsAny(msg, "password authentication failed", "authentication failed")) {
                return "credenciales_invalidas";
            }

            // conexión/DB caída (SQLState clase 08)
            if (state != null && state.startsWith("08")) {
                return "sin_conexion_o_db_caida";
            }

            // fallback por mensaje
            if (containsAny(msg,
                    "connection refused",
                    "could not connect",
                    "connection reset",
                    "connection",
                    "broken pipe",
                    "no route to host",
                    "network is unreachable",
                    "the connection attempt failed",
                    "i/o error")) {
                return "sin_conexion_o_db_caida";
            }
        }


        String exMsg = safeLower(ex.getMessage());
        if (containsAny(exMsg, "timeout", "timed out")) {
            return "timeout";
        }
        if (containsAny(exMsg, "could not get jdbc connection", "connection refused", "could not connect")) {
            return "sin_conexion_o_db_caida";
        }

        return "data_access_error";
    }

    /**
     * Obtiene la causa raíz de una excepción recorriendo la cadena de {@code cause}
     * hasta el último elemento disponible.
     *
     * <p>
     * Este método es seguro frente a ciclos en la cadena de causas
     * (cuando una excepción se referencia a sí misma).
     * </p>
     *
     * @param t excepción inicial.
     * @return la causa raíz de la excepción.
     */
    private static Throwable getRootCause(Throwable t) {
        Throwable cur = t;
        while (cur.getCause() != null && cur.getCause() != cur) {
            cur = cur.getCause();
        }
        return cur;
    }

    /**
     * Retorna una versión en minúsculas de la cadena proporcionada.
     *
     * <p>
     * Si el valor recibido es {@code null}, retorna una cadena vacía,
     * evitando {@link NullPointerException}.
     * </p>
     *
     * @param s cadena de entrada.
     * @return cadena en minúsculas o cadena vacía si {@code s} es {@code null}.
     */
    private static String safeLower(String s) {
        return s == null ? "" : s.toLowerCase();
    }

    /**
     * Verifica si una cadena contiene al menos uno de los valores indicados.
     *
     * <p>
     * La comparación es sensible a mayúsculas/minúsculas, por lo que se recomienda
     * normalizar previamente la cadena de entrada (por ejemplo, usando {@link #safeLower(String)}).
     * </p>
     *
     * <p>
     * Valores {@code null} o vacíos en los parámetros son ignorados de forma segura.
     * </p>
     *
     * @param haystack cadena donde se realizará la búsqueda.
     * @param needles  valores a buscar dentro de la cadena.
     * @return {@code true} si alguno de los valores está contenido en la cadena;
     *         {@code false} en caso contrario.
     */
    private static boolean containsAny(String haystack, String... needles) {
        if (haystack == null || haystack.isEmpty() || needles == null) {
            return false;
        }
        for (String n : needles) {
            if (n != null && !n.isEmpty() && haystack.contains(n)) {
                return true;
            }
        }
        return false;
    }
}
