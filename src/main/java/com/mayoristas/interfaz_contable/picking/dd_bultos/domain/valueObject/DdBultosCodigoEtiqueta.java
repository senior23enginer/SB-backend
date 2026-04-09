package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

public class DdBultosCodigoEtiqueta  {

    private final Long value;

    public DdBultosCodigoEtiqueta(Long value)  {
        validate(value);
        this.value = value;
    }

    public Long getValue()  {
        return value;
    }

    private void validate(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("DdBultosCodigoEtiqueta no puede ser nulo.");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("DdBultosCodigoEtiqueta debe ser mayor que cero.");
        }
    }
}
