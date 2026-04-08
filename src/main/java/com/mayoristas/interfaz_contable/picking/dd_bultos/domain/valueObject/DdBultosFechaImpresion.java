package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

import java.time.LocalDateTime;

public class DdBultosFechaImpresion  {

    private final LocalDateTime value;

    public DdBultosFechaImpresion(LocalDateTime value)  {

        this.value = value;

    }

    public LocalDateTime getValue()  {

        return value;

    }

}
