package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdDetallePickingRowMapper implements RowMapper<DdDetallePicking>  {

    @Override
    public DdDetallePicking mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdDetallePicking(
        rs.getObject("id_recvta", Long.class),
        rs.getObject("inventory_item_id", Long.class),
        rs.getObject("cantidad", Long.class),
        toLocalDateTime(rs.getTimestamp("fecha_registro")),
        rs.getString("usuario_registro"),
        rs.getObject("codigo_etiqueta", Long.class)
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
