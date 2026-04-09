package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdBultosCommandRepository implements DdBultosCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdBultosCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdBultos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO SALCOBRAND.dd_bultos (codigo_etiqueta, id_recvta, impresora, fecha_impresion, usuario_impresion, ind_utilizado)
        VALUES (:codigoEtiqueta, :idRecvta, :impresora, :fechaImpresion, :usuarioImpresion, :indUtilizado)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC)
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("impresora", entity.getImpresora(), Types.VARCHAR)
        .addValue("fechaImpresion", entity.getFechaImpresion(), Types.TIMESTAMP)
        .addValue("usuarioImpresion", entity.getUsuarioImpresion(), Types.VARCHAR)
        .addValue("indUtilizado", entity.getIndUtilizado(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdBultos", ex);

        }

    }

    @Override
    public int update(DdBultos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE SALCOBRAND.dd_bultos
        SET id_recvta = :idRecvta,
        impresora = :impresora,
        fecha_impresion = :fechaImpresion,
        usuario_impresion = :usuarioImpresion,
        ind_utilizado = :indUtilizado
        WHERE codigo_etiqueta = :codigoEtiqueta
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC)
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("impresora", entity.getImpresora(), Types.VARCHAR)
        .addValue("fechaImpresion", entity.getFechaImpresion(), Types.TIMESTAMP)
        .addValue("usuarioImpresion", entity.getUsuarioImpresion(), Types.VARCHAR)
        .addValue("indUtilizado", entity.getIndUtilizado(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdBultos", ex);

        }

    }

    @Override
    public int delete(DdBultosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM SALCOBRAND.dd_bultos
        WHERE codigo_etiqueta = :codigoEtiqueta
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", key.getCodigoEtiqueta(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdBultos", ex);

        }

    }

}

