package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

public class DdBultosIdRecvta  {

    private final Long value;

    public DdBultosIdRecvta(Long value)  {
        validate(value);
        this.value = value;
    }

    public Long getValue()  {
        return value;
    }

    private void validate(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("DdBultosIdRecvta no puede ser nulo.");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("DdBultosIdRecvta debe ser mayor que cero.");
        }
    }
}
