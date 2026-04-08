package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.DdPedidoPicking;
public final class DdPedidoPickingMapper  {
    private DdPedidoPickingMapper() {

    }
    public static DdPedidoPicking from(CreateDdPedidoPickingCommand command) {
        return new DdPedidoPicking(command.getIdRecvta(), command.getEstado(), command.getFechaEstado(), command.getUsuarioEstado(), command.getFechaPicking(), command.getUsuarioPicking(), command.getCodigoEmpresa(), command.getLoCodigo());

    }

}
