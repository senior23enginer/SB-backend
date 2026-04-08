package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions;

public class DdDetallePickingUnexpectedRowsException extends DdDetallePickingException  {
    public DdDetallePickingUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdDetallePicking: "+rows);

    }

}
