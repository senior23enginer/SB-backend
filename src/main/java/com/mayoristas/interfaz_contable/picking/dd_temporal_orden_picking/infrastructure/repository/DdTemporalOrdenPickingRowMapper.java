package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdTemporalOrdenPickingRowMapper implements RowMapper<DdTemporalOrdenPicking>  {

    @Override
    public DdTemporalOrdenPicking mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdTemporalOrdenPicking(
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
