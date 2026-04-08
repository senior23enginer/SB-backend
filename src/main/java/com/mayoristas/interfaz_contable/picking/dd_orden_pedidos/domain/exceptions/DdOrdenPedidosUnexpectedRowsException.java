package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions;

public class DdOrdenPedidosUnexpectedRowsException extends DdOrdenPedidosException  {
    public DdOrdenPedidosUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdOrdenPedidos: "+rows);

    }

}
