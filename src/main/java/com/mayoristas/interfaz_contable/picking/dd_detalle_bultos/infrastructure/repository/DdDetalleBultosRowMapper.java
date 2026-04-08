package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdDetalleBultosRowMapper implements RowMapper<DdDetalleBultos>  {

    @Override
    public DdDetalleBultos mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdDetalleBultos(
        rs.getObject("codigo_etiqueta", Long.class),
        rs.getObject("inventory_item_id", Long.class),
        rs.getObject("cantidad", Long.class)
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
