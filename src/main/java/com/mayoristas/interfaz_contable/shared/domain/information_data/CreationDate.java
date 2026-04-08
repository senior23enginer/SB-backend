package com.mayoristas.interfaz_contable.shared.domain.information_data;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreationDate {
    private LocalDateTime value;

    public CreationDate(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CreationDate{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreationDate that = (CreationDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
