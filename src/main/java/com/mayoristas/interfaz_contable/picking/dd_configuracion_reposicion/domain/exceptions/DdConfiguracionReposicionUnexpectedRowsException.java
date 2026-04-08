package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions;

public class DdConfiguracionReposicionUnexpectedRowsException extends DdConfiguracionReposicionException  {
    public DdConfiguracionReposicionUnexpectedRowsException(int rows) {
        super("Filas inesperadas DdConfiguracionReposicion: "+rows);

    }

}
