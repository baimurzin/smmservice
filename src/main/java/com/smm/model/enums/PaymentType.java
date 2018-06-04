package com.smm.model.enums;

public enum PaymentType {
    ROBOKASSA("robokassa"), PAYPAL("paypal");

    private final String value;

    PaymentType(String paymentProvider) {
        this.value = paymentProvider;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
