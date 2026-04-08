package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions;

public class DdDetallePickingNotFoundException extends DdDetallePickingException  {
    public DdDetallePickingNotFoundException(Object id) {
        super("DdDetallePicking no encontrado. id="+id);

    }

}
