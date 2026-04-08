package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions;

public class DdOrdenPickingException extends RuntimeException  {
    public DdOrdenPickingException(String m) {
        super(m);

    }
    public DdOrdenPickingException(Throwable c) {
        super(c);

    }

}
