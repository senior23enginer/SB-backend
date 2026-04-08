package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.exceptions;

public class DdBultosAlreadyExistsException extends DdBultosException  {

    public DdBultosAlreadyExistsException(Object id)  {

        super("DdBultos ya existe. id=" + id);

    }

}
