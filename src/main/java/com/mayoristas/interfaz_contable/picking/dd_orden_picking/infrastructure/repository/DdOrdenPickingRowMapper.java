package com.mayoristas.interfaz_contable.picking.dd_orden_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdOrdenPickingRowMapper implements RowMapper<DdOrdenPicking>  {

    @Override
    public DdOrdenPicking mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdOrdenPicking(
        rs.getObject("codigo_empresa", Long.class),
        rs.getObject("lo_codigo", Long.class),
        rs.getString("sku"),
        rs.getObject("orden", Long.class),
        rs.getString("sep_1"),
        rs.getString("sep_2"),
        rs.getString("sep_3")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
