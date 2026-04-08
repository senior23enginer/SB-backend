package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions;

public class DdLocalesDespReposicionUnexpectedRowsException extends DdLocalesDespReposicionException  {
    public DdLocalesDespReposicionUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdLocalesDespReposicion: "+rows);

    }

}
