package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions;

public class DdOrdenPickingNotFoundException extends DdOrdenPickingException  {
    public DdOrdenPickingNotFoundException(Object id) {
        super("DdOrdenPicking no encontrado. id="+id);

    }

}
