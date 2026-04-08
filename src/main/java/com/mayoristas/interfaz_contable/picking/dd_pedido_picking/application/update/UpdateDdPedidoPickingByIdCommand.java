package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.update.UpdateDdPedidoPickingCommand;
import java.time.LocalDateTime;

public class UpdateDdPedidoPickingByIdCommand extends UpdateDdPedidoPickingCommand  {
    public UpdateDdPedidoPickingByIdCommand(Long idRecvta, String estado, LocalDateTime fechaEstado, String usuarioEstado, LocalDateTime fechaPicking, String usuarioPicking, Long codigoEmpresa, Long loCodigo) {
        super(idRecvta, estado, fechaEstado, usuarioEstado, fechaPicking, usuarioPicking, codigoEmpresa, loCodigo);

    }

}
