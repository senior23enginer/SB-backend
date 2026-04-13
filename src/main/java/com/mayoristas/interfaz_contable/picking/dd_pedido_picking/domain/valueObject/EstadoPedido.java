package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject;

import java.util.Objects;

public class EstadoPedido {

    private final String value;

    // Estados válidos: CM, EL, EP, IC, PE, SB
    private static final String[] VALID_STATES = {"CM", "EL", "EP", "IC", "PE", "SB"};

    public EstadoPedido(String value) {
        this.value = validateAndNormalize(value);
    }

    public String getValue() {
        return value;
    }

    public boolean isEnPicking() {
        return "EP".equals(value);
    }

    private String validateAndNormalize(String value) {
        if (value == null) {
            throw new IllegalArgumentException("EstadoPedido no puede ser nulo.");
        }

        String normalized = value.trim().toUpperCase();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("EstadoPedido no puede estar vacío.");
        }

        boolean isValid = false;
        for (String state : VALID_STATES) {
            if (state.equals(normalized)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("EstadoPedido debe ser uno de: CM, EL, EP, IC, PE, SB");
        }

        return normalized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoPedido that = (EstadoPedido) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

