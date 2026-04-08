package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions;

public class DdBultosUnexpectedRowsException extends DdBultosException  {

    public DdBultosUnexpectedRowsException(int rows)  {

        super("Filas inesperadas DdBultos: " + rows);

    }

}
