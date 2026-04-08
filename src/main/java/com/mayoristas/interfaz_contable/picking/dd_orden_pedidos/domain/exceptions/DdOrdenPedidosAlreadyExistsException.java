package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions;

public class DdOrdenPedidosAlreadyExistsException extends DdOrdenPedidosException  {
    public DdOrdenPedidosAlreadyExistsException(Object id) {
        super("DdOrdenPedidos ya existe. id="+id);

    }

}
