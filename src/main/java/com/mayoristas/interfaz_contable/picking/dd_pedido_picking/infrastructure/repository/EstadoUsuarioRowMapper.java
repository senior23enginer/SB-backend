package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuario;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.EstadoPedido;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class EstadoUsuarioRowMapper implements RowMapper<EstadoUsuario> {

    @Override
    public EstadoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        String usuarioId = rs.getString("usuario_estado");
        Long localCode = rs.getLong("lo_codigo");
        Long idRecvta = rs.getLong("id_recvta");
        String estado = rs.getString("estado");
        LocalDateTime fechaEstado = rs.getObject("fecha_estado", LocalDateTime.class);

        return new EstadoUsuario(
                new UsuarioId(usuarioId),
                new LocalCode(localCode),
                idRecvta,
                new EstadoPedido(estado),
                fechaEstado
        );
    }
}

