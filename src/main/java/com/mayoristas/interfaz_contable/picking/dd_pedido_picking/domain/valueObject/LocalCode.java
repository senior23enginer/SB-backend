package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject;

import java.util.Objects;

public class LocalCode {

    private final Long value;

    public LocalCode(Long value) {
        validate(value);
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    private void validate(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("LocalCode no puede ser nulo.");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("LocalCode debe ser mayor que cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalCode localCode = (LocalCode) o;
        return Objects.equals(value, localCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

