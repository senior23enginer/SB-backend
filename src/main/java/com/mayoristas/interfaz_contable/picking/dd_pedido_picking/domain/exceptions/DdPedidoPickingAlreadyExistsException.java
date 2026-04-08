package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class DdPedidoPickingAlreadyExistsException extends DdPedidoPickingException  {
    public DdPedidoPickingAlreadyExistsException(Object id) {
        super("DdPedidoPicking ya existe. id="+id);

    }

}
