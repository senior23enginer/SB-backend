package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions;

public class DdListaOrdenPedidosNotFoundException extends DdListaOrdenPedidosException  {
    public DdListaOrdenPedidosNotFoundException(Object id) {
        super("DdListaOrdenPedidos no encontrado. id="+id);

    }

}
