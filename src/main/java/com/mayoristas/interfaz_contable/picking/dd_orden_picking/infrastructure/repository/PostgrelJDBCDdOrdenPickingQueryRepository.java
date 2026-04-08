package com.mayoristas.interfaz_contable.picking.dd_orden_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdOrdenPickingQueryRepository implements DdOrdenPickingQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdOrdenPickingRowMapper mapper;

    public PostgrelJDBCDdOrdenPickingQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdOrdenPickingRowMapper();

    }

    @Override
    public List<DdOrdenPicking> find()  {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo,
        sku,
        orden,
        sep_1,
        sep_2,
        sep_3
        FROM interfaz_contable.dd_orden_picking
        ORDER BY codigo_empresa, lo_codigo, sku
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdOrdenPicking> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo,
        sku,
        orden,
        sep_1,
        sep_2,
        sep_3
        FROM interfaz_contable.dd_orden_picking
        ORDER BY codigo_empresa, lo_codigo, sku
        LIMIT ? OFFSET ?
        """;

        return jdbcTemplate.query(sql, mapper, limit, offset);

    }


    @Override
    public DdOrdenPicking findById(DdOrdenPickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo,
        sku,
        orden,
        sep_1,
        sep_2,
        sep_3
        FROM interfaz_contable.dd_orden_picking
        WHERE codigo_empresa = ? AND lo_codigo = ? AND sku = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresa(), key.getLoCodigo(), key.getSku());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdOrdenPicking por id", ex);

        }

    }

}
