package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdConfiguracionReposicionQueryRepository implements DdConfiguracionReposicionQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdConfiguracionReposicionRowMapper mapper;

    public PostgrelJDBCDdConfiguracionReposicionQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdConfiguracionReposicionRowMapper();

    }

    @Override
    public List<DdConfiguracionReposicion> find()  {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        nombre,
        fecha_ult_ejec,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_configuracion_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdConfiguracionReposicion> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        nombre,
        fecha_ult_ejec,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_configuracion_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdConfiguracionReposicion findById(DdConfiguracionReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        nombre,
        fecha_ult_ejec,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_configuracion_reposicion
        WHERE codigo_empresa_dt = ? AND id_reposicion = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresaDt(), key.getIdReposicion());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdConfiguracionReposicion por id", ex);

        }

    }

}
