package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

public class DdBultosImpresora  {

    private static final int MAX_LENGTH = 20;

    private final String value;

    public DdBultosImpresora(String value)  {
        this.value = validateAndNormalize(value);
    }

    public String getValue()  {
        return value;
    }

    private String validateAndNormalize(String value) {
        if (value == null) {
            throw new IllegalArgumentException("DdBultosImpresora no puede ser nulo.");
        }

        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("DdBultosImpresora no puede estar vacio.");
        }
        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("DdBultosImpresora no puede superar los 20 caracteres.");
        }

        return trimmed;
    }
}
