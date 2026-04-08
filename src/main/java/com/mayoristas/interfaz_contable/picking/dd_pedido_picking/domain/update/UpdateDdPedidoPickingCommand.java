package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create.CreateDdPedidoPickingCommand;
import java.time.LocalDateTime;

public class UpdateDdPedidoPickingCommand extends CreateDdPedidoPickingCommand  {
    public UpdateDdPedidoPickingCommand(Long idRecvta, String estado, LocalDateTime fechaEstado, String usuarioEstado, LocalDateTime fechaPicking, String usuarioPicking, Long codigoEmpresa, Long loCodigo) {
        super(idRecvta, estado, fechaEstado, usuarioEstado, fechaPicking, usuarioPicking, codigoEmpresa, loCodigo);

    }

}
