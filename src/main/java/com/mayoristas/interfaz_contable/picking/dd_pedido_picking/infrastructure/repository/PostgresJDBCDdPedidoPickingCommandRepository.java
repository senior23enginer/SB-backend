package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPickingKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdPedidoPickingCommandRepository implements DdPedidoPickingCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdPedidoPickingCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdPedidoPicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_pedido_picking (id_recvta, estado, fecha_estado, usuario_estado, fecha_picking, usuario_picking, codigo_empresa, lo_codigo)
        VALUES (:idRecvta, :estado, :fechaEstado, :usuarioEstado, :fechaPicking, :usuarioPicking, :codigoEmpresa, :loCodigo)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("estado", entity.getEstado(), Types.VARCHAR)
        .addValue("fechaEstado", entity.getFechaEstado(), Types.TIMESTAMP)
        .addValue("usuarioEstado", entity.getUsuarioEstado(), Types.VARCHAR)
        .addValue("fechaPicking", entity.getFechaPicking(), Types.TIMESTAMP)
        .addValue("usuarioPicking", entity.getUsuarioPicking(), Types.VARCHAR)
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigo", entity.getLoCodigo(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdPedidoPicking", ex);

        }

    }

    @Override
    public int update(DdPedidoPicking entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_pedido_picking
        SET estado = :estado,
        fecha_estado = :fechaEstado,
        usuario_estado = :usuarioEstado,
        fecha_picking = :fechaPicking,
        usuario_picking = :usuarioPicking,
        codigo_empresa = :codigoEmpresa,
        lo_codigo = :loCodigo
        WHERE id_recvta = :idRecvta
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", entity.getIdRecvta(), Types.NUMERIC)
        .addValue("estado", entity.getEstado(), Types.VARCHAR)
        .addValue("fechaEstado", entity.getFechaEstado(), Types.TIMESTAMP)
        .addValue("usuarioEstado", entity.getUsuarioEstado(), Types.VARCHAR)
        .addValue("fechaPicking", entity.getFechaPicking(), Types.TIMESTAMP)
        .addValue("usuarioPicking", entity.getUsuarioPicking(), Types.VARCHAR)
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigo", entity.getLoCodigo(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdPedidoPicking", ex);

        }

    }

    @Override
    public int delete(DdPedidoPickingKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_pedido_picking
        WHERE id_recvta = :idRecvta
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("idRecvta", key.getIdRecvta(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdPedidoPicking", ex);

        }

    }

}
