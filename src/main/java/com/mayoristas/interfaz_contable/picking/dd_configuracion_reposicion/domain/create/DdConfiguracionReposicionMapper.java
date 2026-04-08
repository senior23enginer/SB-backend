package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
public final class DdConfiguracionReposicionMapper  {
    private DdConfiguracionReposicionMapper() {

    }
    public static DdConfiguracionReposicion from(CreateDdConfiguracionReposicionCommand command) {
        return new DdConfiguracionReposicion(command.getCodigoEmpresaDt(), command.getIdReposicion(), command.getNombre(), command.getFechaUltEjec(), command.getIndDeActivo(), command.getFechaCreacion(), command.getCreadoPor(), command.getFechaActualizacion(), command.getActualizadoPor());

    }

}
