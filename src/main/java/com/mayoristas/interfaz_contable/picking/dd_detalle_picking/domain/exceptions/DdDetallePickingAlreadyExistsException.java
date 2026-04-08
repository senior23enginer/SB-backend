package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions;

public class DdDetallePickingAlreadyExistsException extends DdDetallePickingException  {
    public DdDetallePickingAlreadyExistsException(Object id) {
        super("DdDetallePicking ya existe. id="+id);

    }

}
