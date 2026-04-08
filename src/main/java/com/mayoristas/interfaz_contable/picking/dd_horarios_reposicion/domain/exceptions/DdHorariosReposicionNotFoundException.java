package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions;

public class DdHorariosReposicionNotFoundException extends DdHorariosReposicionException  {
    public DdHorariosReposicionNotFoundException(Object id) {
        super("DdHorariosReposicion no encontrado. id="+id);

    }

}
