package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions;

public class DdTemporalOrdenPickingAlreadyExistsException extends DdTemporalOrdenPickingException  {
    public DdTemporalOrdenPickingAlreadyExistsException(Object id) {
        super("DdTemporalOrdenPicking ya existe. id="+id);

    }

}
