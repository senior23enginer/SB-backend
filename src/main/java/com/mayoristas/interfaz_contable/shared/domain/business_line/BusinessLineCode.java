package com.mayoristas.interfaz_contable.shared.domain.business_line;

public class BusinessLineCode {
    private String value;

    public BusinessLineCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BusinessLineCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
