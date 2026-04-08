package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdLocalesDespReposicionRowMapper implements RowMapper<DdLocalesDespReposicion>  {

    @Override
    public DdLocalesDespReposicion mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdLocalesDespReposicion(
        rs.getObject("codigo_empresa_dt", Long.class),
        rs.getObject("id_reposicion", Long.class),
        rs.getObject("codigo_empresa_desp", Long.class),
        rs.getObject("lo_codigo_desp", Long.class),
        toLocalDateTime(rs.getTimestamp("fecha_creacion")),
        rs.getString("creado_por")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
