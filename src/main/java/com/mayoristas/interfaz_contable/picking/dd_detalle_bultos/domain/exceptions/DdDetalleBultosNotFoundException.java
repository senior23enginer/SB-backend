package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions;

public class DdDetalleBultosNotFoundException extends DdDetalleBultosException  {
    public DdDetalleBultosNotFoundException(Object id) {
        super("DdDetalleBultos no encontrado. id="+id);

    }

}
