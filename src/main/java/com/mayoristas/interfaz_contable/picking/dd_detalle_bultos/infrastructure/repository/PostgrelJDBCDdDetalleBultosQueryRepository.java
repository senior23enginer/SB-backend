package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdDetalleBultosQueryRepository implements DdDetalleBultosQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdDetalleBultosRowMapper mapper;

    public PostgrelJDBCDdDetalleBultosQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdDetalleBultosRowMapper();

    }

    @Override
    public List<DdDetalleBultos> find()  {

        String sql = """
        SELECT
        codigo_etiqueta,
        inventory_item_id,
        cantidad
        FROM interfaz_contable.dd_detalle_bultos
        ORDER BY codigo_etiqueta, inventory_item_id
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdDetalleBultos> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_etiqueta,
        inventory_item_id,
        cantidad
        FROM interfaz_contable.dd_detalle_bultos
        ORDER BY codigo_etiqueta, inventory_item_id
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdDetalleBultos findById(DdDetalleBultosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_etiqueta,
        inventory_item_id,
        cantidad
        FROM interfaz_contable.dd_detalle_bultos
        WHERE codigo_etiqueta = ? AND inventory_item_id = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEtiqueta(), key.getInventoryItemId());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdDetalleBultos por id", ex);

        }

    }

}
