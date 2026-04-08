package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions;

public class DdConfiguracionReposicionNotFoundException extends DdConfiguracionReposicionException  {
    public DdConfiguracionReposicionNotFoundException(Object id) {
        super("DdConfiguracionReposicion no encontrado. id="+id);

    }

}
