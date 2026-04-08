package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions;

public class DdDetalleBultosAlreadyExistsException extends DdDetalleBultosException  {
    public DdDetalleBultosAlreadyExistsException(Object id) {
        super("DdDetalleBultos ya existe. id="+id);

    }

}
