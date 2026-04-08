package com.mayoristas.interfaz_contable.shared.domain.business_line;

public class BusinessLineName {
    private String value;

    public BusinessLineName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BusinessLineName{" +
                "value='" + value + '\'' +
                '}';
    }
}
