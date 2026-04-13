package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuario;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuarioQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class OracleJDBCEstadoUsuarioQueryRepository implements EstadoUsuarioQueryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final EstadoUsuarioRowMapper mapper;

    public OracleJDBCEstadoUsuarioQueryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");
        this.mapper = new EstadoUsuarioRowMapper();
    }

    @Override
    public Optional<EstadoUsuario> findByUsuarioAndLocal(UsuarioId usuarioId, LocalCode localCode) {
        Objects.requireNonNull(usuarioId, "usuarioId no puede ser null");
        Objects.requireNonNull(localCode, "localCode no puede ser null");

        String sql = """
            SELECT
                dp.id_recvta,
                dp.estado,
                dp.fecha_estado,
                dp.usuario_estado,
                dp.lo_codigo
            FROM SALCOBRAND.dd_pedido_picking dp
            WHERE dp.usuario_estado = ?
              AND dp.lo_codigo = ?
            ORDER BY dp.fecha_estado DESC
            FETCH FIRST 1 ROW ONLY
            """;

        try {
            List<EstadoUsuario> results = jdbcTemplate.query(
                    sql,
                    mapper,
                    usuarioId.getValue(),
                    localCode.getValue()
            );

            return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error consultando EstadoUsuario", ex);
        }
    }

    @Override
    public boolean existePickingEnCurso(UsuarioId usuarioId, LocalCode localCode) {
        Objects.requireNonNull(usuarioId, "usuarioId no puede ser null");
        Objects.requireNonNull(localCode, "localCode no puede ser null");

        String sql = """
            SELECT COUNT(*)
            FROM SALCOBRAND.dd_pedido_picking dp
            WHERE dp.usuario_estado = ?
              AND dp.lo_codigo = ?
              AND dp.estado = 'EP'
            """;

        try {
            Integer count = jdbcTemplate.queryForObject(
                    sql,
                    Integer.class,
                    usuarioId.getValue(),
                    localCode.getValue()
            );

            return count != null && count > 0;
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error verificando picking en curso", ex);
        }
    }
}

