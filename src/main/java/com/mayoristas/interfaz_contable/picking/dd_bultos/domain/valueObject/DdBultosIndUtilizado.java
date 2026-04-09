package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject;

public class DdBultosIndUtilizado  {

    private final String value;

    public DdBultosIndUtilizado(String value)  {
        this.value = validateAndNormalize(value);
    }

    public String getValue()  {
        return value;
    }

    private String validateAndNormalize(String value) {
        if (value == null) {
            return null;
        }

        String normalized = value.trim().toUpperCase();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("DdBultosIndUtilizado no puede estar vacio.");
        }
        if (!"S".equals(normalized) && !"N".equals(normalized)) {
            throw new IllegalArgumentException("DdBultosIndUtilizado solo permite los valores 'S' o 'N'.");
        }

        return normalized;
    }
}
