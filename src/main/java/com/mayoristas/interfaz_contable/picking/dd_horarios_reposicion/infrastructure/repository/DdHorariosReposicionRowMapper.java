package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Timestamp;

import java.time.LocalDateTime;

public class DdHorariosReposicionRowMapper implements RowMapper<DdHorariosReposicion>  {

    @Override
    public DdHorariosReposicion mapRow(ResultSet rs, int rowNum) throws SQLException  {

        return new DdHorariosReposicion(
        rs.getObject("codigo_empresa_dt", Long.class),
        rs.getObject("id_reposicion", Long.class),
        toLocalDateTime(rs.getTimestamp("hora")),
        rs.getString("ind_de_activo"),
        toLocalDateTime(rs.getTimestamp("fecha_creacion")),
        rs.getString("creado_por"),
        toLocalDateTime(rs.getTimestamp("fecha_actualizacion")),
        rs.getString("actualizado_por")
        );

    }

    private static LocalDateTime toLocalDateTime(Timestamp ts)  {

        return ts != null ? ts.toLocalDateTime() : null;

    }

}
