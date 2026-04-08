package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdHorariosReposicionCommandRepository implements DdHorariosReposicionCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdHorariosReposicionCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdHorariosReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_horarios_reposicion (codigo_empresa_dt, id_reposicion, hora, ind_de_activo, fecha_creacion, creado_por, fecha_actualizacion, actualizado_por)
        VALUES (:codigoEmpresaDt, :idReposicion, :hora, :indDeActivo, :fechaCreacion, :creadoPor, :fechaActualizacion, :actualizadoPor)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("hora", entity.getHora(), Types.TIMESTAMP)
        .addValue("indDeActivo", entity.getIndDeActivo(), Types.VARCHAR)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualizacion", entity.getFechaActualizacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdHorariosReposicion", ex);

        }

    }

    @Override
    public int update(DdHorariosReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_horarios_reposicion
        SET ind_de_activo = :indDeActivo,
        fecha_creacion = :fechaCreacion,
        creado_por = :creadoPor,
        fecha_actualizacion = :fechaActualizacion,
        actualizado_por = :actualizadoPor
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion AND hora = :hora
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("hora", entity.getHora(), Types.TIMESTAMP)
        .addValue("indDeActivo", entity.getIndDeActivo(), Types.VARCHAR)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualizacion", entity.getFechaActualizacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdHorariosReposicion", ex);

        }

    }

    @Override
    public int delete(DdHorariosReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_horarios_reposicion
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion AND hora = :hora
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", key.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", key.getIdReposicion(), Types.NUMERIC)
        .addValue("hora", key.getHora(), Types.TIMESTAMP);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdHorariosReposicion", ex);

        }

    }

}
