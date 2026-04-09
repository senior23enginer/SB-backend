package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

public class DdBultosUsuarioImpresion  {

    private static final int MAX_LENGTH = 100;

    private final String value;

    public DdBultosUsuarioImpresion(String value)  {
        this.value = validateAndNormalize(value);
    }

    public String getValue()  {
        return value;
    }

    private String validateAndNormalize(String value) {
        if (value == null) {
            throw new IllegalArgumentException("DdBultosUsuarioImpresion no puede ser nulo.");
        }

        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("DdBultosUsuarioImpresion no puede estar vacio.");
        }
        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("DdBultosUsuarioImpresion no puede superar los 100 caracteres.");
        }

        return trimmed;
    }
}
