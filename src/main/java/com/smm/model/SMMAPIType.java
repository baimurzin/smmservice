package com.smm.model;

public enum  SMMAPIType {
    SMMLABA("smmlaba");

    private final String value;

    SMMAPIType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
