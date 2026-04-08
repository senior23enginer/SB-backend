package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdLocalesDespReposicionCommandRepository implements DdLocalesDespReposicionCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdLocalesDespReposicionCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdLocalesDespReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_locales_desp_reposicion (codigo_empresa_dt, id_reposicion, codigo_empresa_desp, lo_codigo_desp, fecha_creacion, creado_por)
        VALUES (:codigoEmpresaDt, :idReposicion, :codigoEmpresaDesp, :loCodigoDesp, :fechaCreacion, :creadoPor)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("codigoEmpresaDesp", entity.getCodigoEmpresaDesp(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdLocalesDespReposicion", ex);

        }

    }

    @Override
    public int update(DdLocalesDespReposicion entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_locales_desp_reposicion
        SET fecha_creacion = :fechaCreacion,
        creado_por = :creadoPor
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion AND codigo_empresa_desp = :codigoEmpresaDesp AND lo_codigo_desp = :loCodigoDesp
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", entity.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", entity.getIdReposicion(), Types.NUMERIC)
        .addValue("codigoEmpresaDesp", entity.getCodigoEmpresaDesp(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdLocalesDespReposicion", ex);

        }

    }

    @Override
    public int delete(DdLocalesDespReposicionKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_locales_desp_reposicion
        WHERE codigo_empresa_dt = :codigoEmpresaDt AND id_reposicion = :idReposicion AND codigo_empresa_desp = :codigoEmpresaDesp AND lo_codigo_desp = :loCodigoDesp
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresaDt", key.getCodigoEmpresaDt(), Types.NUMERIC)
        .addValue("idReposicion", key.getIdReposicion(), Types.NUMERIC)
        .addValue("codigoEmpresaDesp", key.getCodigoEmpresaDesp(), Types.NUMERIC)
        .addValue("loCodigoDesp", key.getLoCodigoDesp(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdLocalesDespReposicion", ex);

        }

    }

}
