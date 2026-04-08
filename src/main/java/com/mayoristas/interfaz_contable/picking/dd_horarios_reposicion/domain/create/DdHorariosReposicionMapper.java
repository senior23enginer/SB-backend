package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
public final class DdHorariosReposicionMapper  {
    private DdHorariosReposicionMapper() {

    }
    public static DdHorariosReposicion from(CreateDdHorariosReposicionCommand command) {
        return new DdHorariosReposicion(command.getCodigoEmpresaDt(), command.getIdReposicion(), command.getHora(), command.getIndDeActivo(), command.getFechaCreacion(), command.getCreadoPor(), command.getFechaActualizacion(), command.getActualizadoPor());

    }

}
