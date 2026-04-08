package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdListaOrdenPedidosRowMapper implements RowMapper<DdListaOrdenPedidos>  {

    @Override
    public DdListaOrdenPedidos mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdListaOrdenPedidos(
        rs.getObject("codigo_empresa", Long.class),
        rs.getObject("lo_codigo_desp", Long.class),
        rs.getString("codigo_lista"),
        rs.getString("codigo_elemento"),
        rs.getObject("org_id_inv", Long.class),
        rs.getObject("orden_elemento", Long.class),
        toLocalDateTime(rs.getTimestamp("fecha_creacion")),
        rs.getString("creado_por")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
