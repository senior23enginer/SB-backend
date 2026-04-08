package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdDetallePickingCommandRepository implements DdDetallePickingCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdDetallePickingCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdDetallePicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_detalle_picking (id_recvta, inventory_item_id, cantidad, fecha_registro, usuario_registro, codigo_etiqueta)
        VALUES (:idRecvta, :inventoryItemId, :cantidad, :fechaRegistro, :usuarioRegistro, :codigoEtiqueta)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("inventoryItemId", entity.getInventoryItemId(), Types.NUMERIC)
        .addValue("cantidad", entity.getCantidad(), Types.NUMERIC)
        .addValue("fechaRegistro", entity.getFechaRegistro(), Types.TIMESTAMP)
        .addValue("usuarioRegistro", entity.getUsuarioRegistro(), Types.VARCHAR)
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdDetallePicking", ex);

        }

    }

    @Override
    public int update(DdDetallePicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_detalle_picking
        SET cantidad = :cantidad,
        fecha_registro = :fechaRegistro,
        usuario_registro = :usuarioRegistro,
        codigo_etiqueta = :codigoEtiqueta
        WHERE id_recvta = :idRecvta AND inventory_item_id = :inventoryItemId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("inventoryItemId", entity.getInventoryItemId(), Types.NUMERIC)
        .addValue("cantidad", entity.getCantidad(), Types.NUMERIC)
        .addValue("fechaRegistro", entity.getFechaRegistro(), Types.TIMESTAMP)
        .addValue("usuarioRegistro", entity.getUsuarioRegistro(), Types.VARCHAR)
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdDetallePicking", ex);

        }

    }

    @Override
    public int delete(DdDetallePickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_detalle_picking
        WHERE id_recvta = :idRecvta AND inventory_item_id = :inventoryItemId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", key.getIdRecvta(), Types.NUMERIC)
        .addValue("inventoryItemId", key.getInventoryItemId(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdDetallePicking", ex);

        }

    }

}
