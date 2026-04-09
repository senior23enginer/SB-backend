package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdPedidoPickingQueryRepository implements DdPedidoPickingQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdPedidoPickingRowMapper mapper;

    public PostgrelJDBCDdPedidoPickingQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdPedidoPickingRowMapper();

    }

    @Override
    public List<DdPedidoPicking> find()  {

        String sql = """
        SELECT
        id_recvta,
        estado,
        fecha_estado,
        usuario_estado,
        fecha_picking,
        usuario_picking,
        codigo_empresa,
        lo_codigo
        FROM interfaz_contable.dd_pedido_picking
        ORDER BY id_recvta
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdPedidoPicking> find(int limit, int offset) {

        String sql = """
        SELECT
        id_recvta,
        estado,
        fecha_estado,
        usuario_estado,
        fecha_picking,
        usuario_picking,
        codigo_empresa,
        lo_codigo
        FROM interfaz_contable.dd_pedido_picking
        ORDER BY id_recvta
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdPedidoPicking findById(DdPedidoPickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        id_recvta,
        estado,
        fecha_estado,
        usuario_estado,
        fecha_picking,
        usuario_picking,
        codigo_empresa,
        lo_codigo
        FROM interfaz_contable.dd_pedido_picking
        WHERE id_recvta = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getIdRecvta());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdPedidoPicking por id", ex);

        }

    }

}
