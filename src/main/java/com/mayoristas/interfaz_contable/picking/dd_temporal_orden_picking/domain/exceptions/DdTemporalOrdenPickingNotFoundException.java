package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions;

public class DdTemporalOrdenPickingNotFoundException extends DdTemporalOrdenPickingException  {
    public DdTemporalOrdenPickingNotFoundException(Object id) {
        super("DdTemporalOrdenPicking no encontrado. id="+id);

    }

}
