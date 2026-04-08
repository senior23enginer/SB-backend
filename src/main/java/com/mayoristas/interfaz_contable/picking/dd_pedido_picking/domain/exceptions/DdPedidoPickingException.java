package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class DdPedidoPickingException extends RuntimeException  {
    public DdPedidoPickingException(String m) {
        super(m);

    }
    public DdPedidoPickingException(Throwable c) {
        super(c);

    }

}
