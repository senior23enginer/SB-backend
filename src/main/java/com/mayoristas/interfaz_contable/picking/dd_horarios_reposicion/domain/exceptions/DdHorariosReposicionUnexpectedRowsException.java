package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions;

public class DdHorariosReposicionUnexpectedRowsException extends DdHorariosReposicionException  {
    public DdHorariosReposicionUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdHorariosReposicion: "+rows);

    }

}
