package com.mayoristas.interfaz_contable.picking.dd_bultos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdBultosRowMapper implements RowMapper<DdBultos>  {

    @Override
    public DdBultos mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdBultos(
        rs.getObject("codigo_etiqueta", Long.class),
        rs.getObject("id_recvta", Long.class),
        rs.getString("impresora"),
        toLocalDateTime(rs.getTimestamp("fecha_impresion")),
        rs.getString("usuario_impresion"),
        rs.getString("ind_utilizado")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
