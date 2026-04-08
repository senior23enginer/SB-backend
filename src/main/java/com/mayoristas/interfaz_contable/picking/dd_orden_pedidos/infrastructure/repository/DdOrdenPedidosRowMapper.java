package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdOrdenPedidosRowMapper implements RowMapper<DdOrdenPedidos>  {

    @Override
    public DdOrdenPedidos mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdOrdenPedidos(
        rs.getObject("codigo_empresa", Long.class),
        rs.getObject("lo_codigo_desp", Long.class),
        rs.getString("check_comuna"),
        rs.getString("check_marca"),
        rs.getString("check_producto"),
        rs.getString("ind_and_or_prod"),
        rs.getString("ind_inc_exc"),
        rs.getString("check_stock"),
        rs.getString("sin_stock"),
        rs.getString("con_stock"),
        rs.getString("check_cant_prod"),
        rs.getObject("cant_prod_desde", Long.class),
        rs.getObject("cant_prod_hasta", Long.class),
        rs.getString("chec_precio"),
        rs.getObject("precio_desde", Long.class),
        rs.getObject("precio_hasta", Long.class),
        toLocalDateTime(rs.getTimestamp("fecha_creacion")),
        rs.getString("creado_por"),
        toLocalDateTime(rs.getTimestamp("fecha_actualicacion")),
        rs.getString("actualizado_por")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
