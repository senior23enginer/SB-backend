package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions;

public class DdLocalesDespReposicionNotFoundException extends DdLocalesDespReposicionException  {
    public DdLocalesDespReposicionNotFoundException(Object id) {
        super("DdLocalesDespReposicion no encontrado. id="+id);

    }

}
