package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdConfiguracionReposicionCommandRepository implements DdConfiguracionReposicionCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdConfiguracionReposicionCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdConfiguracionReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_configuracion_reposicion (codigo_empresa_dt, id_reposicion, nombre, fecha_ult_ejec, ind_de_activo, fecha_creacion, creado_por, fecha_actualizacion, actualizado_por)
        VALUES (:codigoEmpresaDt, :idReposicion, :nombre, :fechaUltEjec, :indDeActivo, :fechaCreacion, :creadoPor, :fechaActualizacion, :actualizadoPor)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("nombre", entity.getNombre(), Types.VARCHAR)
        .addValue("fechaUltEjec", entity.getFechaUltEjec(), Types.TIMESTAMP)
        .addValue("indDeActivo", entity.getIndDeActivo(), Types.VARCHAR)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualizacion", entity.getFechaActualizacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdConfiguracionReposicion", ex);

        }

    }

    @Override
    public int update(DdConfiguracionReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_configuracion_reposicion
        SET nombre = :nombre,
        fecha_ult_ejec = :fechaUltEjec,
        ind_de_activo = :indDeActivo,
        fecha_creacion = :fechaCreacion,
        creado_por = :creadoPor,
        fecha_actualizacion = :fechaActualizacion,
        actualizado_por = :actualizadoPor
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("nombre", entity.getNombre(), Types.VARCHAR)
        .addValue("fechaUltEjec", entity.getFechaUltEjec(), Types.TIMESTAMP)
        .addValue("indDeActivo", entity.getIndDeActivo(), Types.VARCHAR)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualizacion", entity.getFechaActualizacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdConfiguracionReposicion", ex);

        }

    }

    @Override
    public int delete(DdConfiguracionReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_configuracion_reposicion
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", key.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", key.getIdReposicion(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdConfiguracionReposicion", ex);

        }

    }

}
