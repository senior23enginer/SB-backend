package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions;

public class DdLocalesDespReposicionAlreadyExistsException extends DdLocalesDespReposicionException  {
    public DdLocalesDespReposicionAlreadyExistsException(Object id) {
        super("DdLocalesDespReposicion ya existe. id="+id);

    }

}
