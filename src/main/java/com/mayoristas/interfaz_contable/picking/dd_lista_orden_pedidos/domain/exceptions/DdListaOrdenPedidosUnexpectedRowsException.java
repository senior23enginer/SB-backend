package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions;

public class DdListaOrdenPedidosUnexpectedRowsException extends DdListaOrdenPedidosException  {
    public DdListaOrdenPedidosUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdListaOrdenPedidos: "+rows);

    }

}
