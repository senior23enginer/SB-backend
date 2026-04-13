package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject;

import java.util.Objects;

public class UsuarioId {

    private final String value;

    public UsuarioId(String value) {
        this.value = validateAndNormalize(value);
    }

    public String getValue() {
        return value;
    }

    private String validateAndNormalize(String value) {
        if (value == null) {
            throw new IllegalArgumentException("UsuarioId no puede ser nulo.");
        }

        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("UsuarioId no puede estar vacío.");
        }

        return trimmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioId usuarioId = (UsuarioId) o;
        return Objects.equals(value, usuarioId.value);
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

