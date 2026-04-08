package com.mayoristas.interfaz_contable.picking.dd_orden_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdOrdenPickingCommandRepository implements DdOrdenPickingCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdOrdenPickingCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdOrdenPicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_orden_picking (codigo_empresa, lo_codigo, sku, orden, sep_1, sep_2, sep_3)
        VALUES (:codigoEmpresa, :loCodigo, :sku, :orden, :sep1, :sep2, :sep3)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigo", entity.getLoCodigo(), Types.NUMERIC)
        .addValue("sku", entity.getSku(), Types.VARCHAR)
        .addValue("orden", entity.getOrden(), Types.NUMERIC)
        .addValue("sep1", entity.getSep1(), Types.VARCHAR)
        .addValue("sep2", entity.getSep2(), Types.VARCHAR)
        .addValue("sep3", entity.getSep3(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdOrdenPicking", ex);

        }

    }

    @Override
    public int update(DdOrdenPicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_orden_picking
        SET orden = :orden,
        sep_1 = :sep1,
        sep_2 = :sep2,
        sep_3 = :sep3
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo = :loCodigo AND sku = :sku
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigo", entity.getLoCodigo(), Types.NUMERIC)
        .addValue("sku", entity.getSku(), Types.VARCHAR)
        .addValue("orden", entity.getOrden(), Types.NUMERIC)
        .addValue("sep1", entity.getSep1(), Types.VARCHAR)
        .addValue("sep2", entity.getSep2(), Types.VARCHAR)
        .addValue("sep3", entity.getSep3(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdOrdenPicking", ex);

        }

    }

    @Override
    public int delete(DdOrdenPickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_orden_picking
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo = :loCodigo AND sku = :sku
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", key.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigo", key.getLoCodigo(), Types.NUMERIC)
        .addValue("sku", key.getSku(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdOrdenPicking", ex);

        }

    }

}
