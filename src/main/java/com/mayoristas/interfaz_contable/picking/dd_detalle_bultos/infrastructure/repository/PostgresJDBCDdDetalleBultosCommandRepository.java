package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdDetalleBultosCommandRepository implements DdDetalleBultosCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdDetalleBultosCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdDetalleBultos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_detalle_bultos (codigo_etiqueta, inventory_item_id, cantidad)
        VALUES (:codigoEtiqueta, :inventoryItemId, :cantidad)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC)
        .addValue("inventoryItemId", entity.getInventoryItemId(), Types.NUMERIC)
        .addValue("cantidad", entity.getCantidad(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdDetalleBultos", ex);

        }

    }

    @Override
    public int update(DdDetalleBultos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_detalle_bultos
        SET cantidad = :cantidad
        WHERE codigo_etiqueta = :codigoEtiqueta AND inventory_item_id = :inventoryItemId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", entity.getCodigoEtiqueta(), Types.NUMERIC)
        .addValue("inventoryItemId", entity.getInventoryItemId(), Types.NUMERIC)
        .addValue("cantidad", entity.getCantidad(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdDetalleBultos", ex);

        }

    }

    @Override
    public int delete(DdDetalleBultosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_detalle_bultos
        WHERE codigo_etiqueta = :codigoEtiqueta AND inventory_item_id = :inventoryItemId
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEtiqueta", key.getCodigoEtiqueta(), Types.NUMERIC)
        .addValue("inventoryItemId", key.getInventoryItemId(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdDetalleBultos", ex);

        }

    }

}
