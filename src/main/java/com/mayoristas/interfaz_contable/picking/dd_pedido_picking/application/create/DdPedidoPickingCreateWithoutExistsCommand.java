package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create.CreateDdPedidoPickingCommand;

import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking}
 * validando previamente que no exista por llave primaria.
 */
public class DdPedidoPickingCreateWithoutExistsCommand extends CreateDdPedidoPickingCommand {

    public DdPedidoPickingCreateWithoutExistsCommand(Long idRecvta, String estado, LocalDateTime fechaEstado,
                                                     String usuarioEstado, LocalDateTime fechaPicking,
                                                     String usuarioPicking, Long codigoEmpresa, Long loCodigo) {
        super(idRecvta, estado, fechaEstado, usuarioEstado, fechaPicking, usuarioPicking, codigoEmpresa, loCodigo);
    }
}
