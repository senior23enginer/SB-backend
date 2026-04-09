package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdLocalesDespReposicionQueryRepository implements DdLocalesDespReposicionQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdLocalesDespReposicionRowMapper mapper;

    public PostgrelJDBCDdLocalesDespReposicionQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdLocalesDespReposicionRowMapper();

    }

    @Override
    public List<DdLocalesDespReposicion> find()  {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        codigo_empresa_desp,
        lo_codigo_desp,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_locales_desp_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion, codigo_empresa_desp, lo_codigo_desp
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdLocalesDespReposicion> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        codigo_empresa_desp,
        lo_codigo_desp,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_locales_desp_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion, codigo_empresa_desp, lo_codigo_desp
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdLocalesDespReposicion findById(DdLocalesDespReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        codigo_empresa_desp,
        lo_codigo_desp,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_locales_desp_reposicion
        WHERE codigo_empresa_dt = ? AND id_reposicion = ? AND codigo_empresa_desp = ? AND lo_codigo_desp = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresaDt(), key.getIdReposicion(), key.getCodigoEmpresaDesp(), key.getLoCodigoDesp());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdLocalesDespReposicion por id", ex);

        }

    }

}
