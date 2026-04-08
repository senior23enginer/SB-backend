package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions;

public class DdOrdenPedidosNotFoundException extends DdOrdenPedidosException  {
    public DdOrdenPedidosNotFoundException(Object id) {
        super("DdOrdenPedidos no encontrado. id="+id);

    }

}
