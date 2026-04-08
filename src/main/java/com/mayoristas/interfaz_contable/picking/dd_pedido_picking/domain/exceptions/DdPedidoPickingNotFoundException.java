package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class DdPedidoPickingNotFoundException extends DdPedidoPickingException  {
    public DdPedidoPickingNotFoundException(Object id) {
        super("DdPedidoPicking no encontrado. id="+id);

    }

}
