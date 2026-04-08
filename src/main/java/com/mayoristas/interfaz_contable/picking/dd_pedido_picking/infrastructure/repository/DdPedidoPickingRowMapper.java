package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdPedidoPickingRowMapper implements RowMapper<DdPedidoPicking>  {

    @Override
    public DdPedidoPicking mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdPedidoPicking(
        rs.getObject("id_recvta", Long.class),
        rs.getString("estado"),
        toLocalDateTime(rs.getTimestamp("fecha_estado")),
        rs.getString("usuario_estado"),
        toLocalDateTime(rs.getTimestamp("fecha_picking")),
        rs.getString("usuario_picking"),
        rs.getObject("codigo_empresa", Long.class),
        rs.getObject("lo_codigo", Long.class)
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
