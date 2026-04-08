package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdListaOrdenPedidosCommandRepository implements DdListaOrdenPedidosCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdListaOrdenPedidosCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdListaOrdenPedidos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_lista_orden_pedidos (codigo_empresa, lo_codigo_desp, codigo_lista, codigo_elemento, org_id_inv, orden_elemento, fecha_creacion, creado_por)
        VALUES (:codigoEmpresa, :loCodigoDesp, :codigoLista, :codigoElemento, :orgIdInv, :ordenElemento, :fechaCreacion, :creadoPor)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("codigoLista", entity.getCodigoLista(), Types.VARCHAR)
        .addValue("codigoElemento", entity.getCodigoElemento(), Types.VARCHAR)
        .addValue("orgIdInv", entity.getOrgIdInv(), Types.NUMERIC)
        .addValue("ordenElemento", entity.getOrdenElemento(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdListaOrdenPedidos", ex);

        }

    }

    @Override
    public int update(DdListaOrdenPedidos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_lista_orden_pedidos
        SET org_id_inv = :orgIdInv,
        orden_elemento = :ordenElemento,
        fecha_creacion = :fechaCreacion,
        creado_por = :creadoPor
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo_desp = :loCodigoDesp AND codigo_lista = :codigoLista AND codigo_elemento = :codigoElemento
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("codigoLista", entity.getCodigoLista(), Types.VARCHAR)
        .addValue("codigoElemento", entity.getCodigoElemento(), Types.VARCHAR)
        .addValue("orgIdInv", entity.getOrgIdInv(), Types.NUMERIC)
        .addValue("ordenElemento", entity.getOrdenElemento(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdListaOrdenPedidos", ex);

        }

    }

    @Override
    public int delete(DdListaOrdenPedidosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_lista_orden_pedidos
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo_desp = :loCodigoDesp AND codigo_lista = :codigoLista AND codigo_elemento = :codigoElemento
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", key.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", key.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("codigoLista", key.getCodigoLista(), Types.VARCHAR)
        .addValue("codigoElemento", key.getCodigoElemento(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdListaOrdenPedidos", ex);

        }

    }

}
