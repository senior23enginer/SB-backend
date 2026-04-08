package com.mayoristas.interfaz_contable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test de carga de contexto.
 *
 * <p>
 * Este proyecto está orientado a pruebas unitarias (sin infraestructura).
 * {@link SpringBootTest} levanta el ApplicationContext completo y, por la configuración
 * de Spring Data JDBC, intenta obtener una conexión real a la base de datos.
 * </p>
 *
 * <p>
 * Por eso este test se deja deshabilitado. Para pruebas de integración, crear un suite
 * separado con perfil test + BD embebida (H2/Testcontainers) o con infraestructura levantada.
 * </p>
 */
@SpringBootTest
@Disabled("Requiere DB levantada para cargar el ApplicationContext. Se deshabilita para unit tests.")
class InterfazBackendApplicationTests {

    @Test
    void contextLoads() {
        // no-op
    }
}
