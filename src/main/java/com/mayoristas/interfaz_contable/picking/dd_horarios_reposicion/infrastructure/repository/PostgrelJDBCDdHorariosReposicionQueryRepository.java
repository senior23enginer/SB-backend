package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdHorariosReposicionQueryRepository implements DdHorariosReposicionQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdHorariosReposicionRowMapper mapper;

    public PostgrelJDBCDdHorariosReposicionQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdHorariosReposicionRowMapper();

    }

    @Override
    public List<DdHorariosReposicion> find()  {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        hora,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_horarios_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion, hora
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdHorariosReposicion> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        hora,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_horarios_reposicion
        ORDER BY codigo_empresa_dt, id_reposicion, hora
        LIMIT ? OFFSET ?
        """;

        return jdbcTemplate.query(sql, mapper, limit, offset);

    }


    @Override
    public DdHorariosReposicion findById(DdHorariosReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa_dt,
        id_reposicion,
        hora,
        ind_de_activo,
        fecha_creacion,
        creado_por,
        fecha_actualizacion,
        actualizado_por
        FROM interfaz_contable.dd_horarios_reposicion
        WHERE codigo_empresa_dt = ? AND id_reposicion = ? AND hora = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresaDt(), key.getIdReposicion(), key.getHora());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdHorariosReposicion por id", ex);

        }

    }

}
