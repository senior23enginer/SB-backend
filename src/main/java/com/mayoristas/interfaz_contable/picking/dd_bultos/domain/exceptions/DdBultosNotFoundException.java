package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions;

public class DdBultosNotFoundException extends DdBultosException  {

    public DdBultosNotFoundException(Object id)  {

        super("DdBultos no encontrado. id=" + id);

    }

}
