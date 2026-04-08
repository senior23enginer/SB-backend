package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions;

public class DdDetalleBultosUnexpectedRowsException extends DdDetalleBultosException  {
    public DdDetalleBultosUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdDetalleBultos: "+rows);

    }

}
