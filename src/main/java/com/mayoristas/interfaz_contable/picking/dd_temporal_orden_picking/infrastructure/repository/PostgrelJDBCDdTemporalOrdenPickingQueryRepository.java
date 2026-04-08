package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdTemporalOrdenPickingQueryRepository implements DdTemporalOrdenPickingQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdTemporalOrdenPickingRowMapper mapper;

    public PostgrelJDBCDdTemporalOrdenPickingQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdTemporalOrdenPickingRowMapper();

    }

    @Override
    public List<DdTemporalOrdenPicking> find()  {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo,
        sku,
        orden,
        sep_1,
        sep_2,
        sep_3
        FROM interfaz_contable.dd_temporal_orden_picking
        ORDER BY codigo_empresa, lo_codigo, sku
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdTemporalOrdenPicking> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo,
        sku,
        orden,
        sep_1,
        sep_2,
        sep_3
        FROM interfaz_contable.dd_temporal_orden_picking
        ORDER BY codigo_empresa, lo_codigo, sku
        LIMIT ? OFFSET ?
        """;

        return jdbcTemplate.query(sql, mapper, limit, offset);

    }


    @Override
    public DdTemporalOrdenPicking findById(DdTemporalOrdenPickingKey key)  {

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
        FROM interfaz_contable.dd_temporal_orden_picking
        WHERE codigo_empresa = ? AND lo_codigo = ? AND sku = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresa(), key.getLoCodigo(), key.getSku());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdTemporalOrdenPicking por id", ex);

        }

    }

}
