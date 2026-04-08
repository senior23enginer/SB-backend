package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions;

public class DdOrdenPickingUnexpectedRowsException extends DdOrdenPickingException  {
    public DdOrdenPickingUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdOrdenPicking: "+rows);

    }

}
