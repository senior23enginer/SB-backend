package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions;

public class DdListaOrdenPedidosAlreadyExistsException extends DdListaOrdenPedidosException  {
    public DdListaOrdenPedidosAlreadyExistsException(Object id) {
        super("DdListaOrdenPedidos ya existe. id="+id);

    }

}
