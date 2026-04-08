package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class DdPedidoPickingUnexpectedRowsException extends DdPedidoPickingException  {
    public DdPedidoPickingUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdPedidoPicking: "+rows);

    }

}
