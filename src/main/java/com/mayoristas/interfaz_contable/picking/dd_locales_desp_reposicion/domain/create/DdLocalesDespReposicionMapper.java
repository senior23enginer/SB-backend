package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
public final class DdLocalesDespReposicionMapper  {
    private DdLocalesDespReposicionMapper() {

    }
    public static DdLocalesDespReposicion from(CreateDdLocalesDespReposicionCommand command) {
        return new DdLocalesDespReposicion(command.getCodigoEmpresaDt(), command.getIdReposicion(), command.getCodigoEmpresaDesp(), command.getLoCodigoDesp(), command.getFechaCreacion(), command.getCreadoPor());

    }

}
