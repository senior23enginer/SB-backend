package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions;

public class DdOrdenPickingAlreadyExistsException extends DdOrdenPickingException  {
    public DdOrdenPickingAlreadyExistsException(Object id) {
        super("DdOrdenPicking ya existe. id="+id);

    }

}
