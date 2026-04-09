package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdBultosQueryRepository implements DdBultosQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdBultosRowMapper mapper;

    public PostgrelJDBCDdBultosQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdBultosRowMapper();

    }

    @Override
    public List<DdBultos> find()  {

        String sql = """
        SELECT
        codigo_etiqueta,
        id_recvta,
        impresora,
        fecha_impresion,
        usuario_impresion,
        ind_utilizado
        FROM interfaz_contable.dd_bultos
        ORDER BY codigo_etiqueta
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdBultos> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_etiqueta,
        id_recvta,
        impresora,
        fecha_impresion,
        usuario_impresion,
        ind_utilizado
        FROM interfaz_contable.dd_bultos
        ORDER BY codigo_etiqueta
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdBultos findById(DdBultosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_etiqueta,
        id_recvta,
        impresora,
        fecha_impresion,
        usuario_impresion,
        ind_utilizado
        FROM interfaz_contable.dd_bultos
        WHERE codigo_etiqueta = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEtiqueta());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdBultos por id", ex);

        }

    }

}
