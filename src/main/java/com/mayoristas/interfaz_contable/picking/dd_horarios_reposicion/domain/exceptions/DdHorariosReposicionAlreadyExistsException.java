package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions;

public class DdHorariosReposicionAlreadyExistsException extends DdHorariosReposicionException  {
    public DdHorariosReposicionAlreadyExistsException(Object id) {
        super("DdHorariosReposicion ya existe. id="+id);

    }

}
