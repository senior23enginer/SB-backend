package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions;

public class DdTemporalOrdenPickingUnexpectedRowsException extends DdTemporalOrdenPickingException  {
    public DdTemporalOrdenPickingUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdTemporalOrdenPicking: "+rows);

    }

}
