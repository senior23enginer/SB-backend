package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DdBultosFechaImpresion  {

    private final LocalDateTime value;

    public DdBultosFechaImpresion(LocalDateTime value)  {
        this.value = Objects.requireNonNull(value, "DdBultosFechaImpresion no puede ser nulo.");
    }

    public LocalDateTime getValue()  {
        return value;
    }

}
