package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdDetallePickingQueryRepository implements DdDetallePickingQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdDetallePickingRowMapper mapper;

    public PostgrelJDBCDdDetallePickingQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdDetallePickingRowMapper();

    }

    @Override
    public List<DdDetallePicking> find()  {

        String sql = """
        SELECT
        id_recvta,
        inventory_item_id,
        cantidad,
        fecha_registro,
        usuario_registro,
        codigo_etiqueta
        FROM interfaz_contable.dd_detalle_picking
        ORDER BY id_recvta, inventory_item_id
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdDetallePicking> find(int limit, int offset) {

        String sql = """
        SELECT
        id_recvta,
        inventory_item_id,
        cantidad,
        fecha_registro,
        usuario_registro,
        codigo_etiqueta
        FROM interfaz_contable.dd_detalle_picking
        ORDER BY id_recvta, inventory_item_id
        LIMIT ? OFFSET ?
        """;

        return jdbcTemplate.query(sql, mapper, limit, offset);

    }


    @Override
    public DdDetallePicking findById(DdDetallePickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        id_recvta,
        inventory_item_id,
        cantidad,
        fecha_registro,
        usuario_registro,
        codigo_etiqueta
        FROM interfaz_contable.dd_detalle_picking
        WHERE id_recvta = ? AND inventory_item_id = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getIdRecvta(), key.getInventoryItemId());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdDetallePicking por id", ex);

        }

    }

}
