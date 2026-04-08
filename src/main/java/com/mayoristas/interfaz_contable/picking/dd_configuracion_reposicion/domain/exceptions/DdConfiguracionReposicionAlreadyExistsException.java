package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions;

public class DdConfiguracionReposicionAlreadyExistsException extends DdConfiguracionReposicionException  {
    public DdConfiguracionReposicionAlreadyExistsException(Object id) {
        super("DdConfiguracionReposicion ya existe. id="+id);

    }

}
