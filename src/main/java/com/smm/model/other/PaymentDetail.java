package com.smm.model.other;

import com.smm.model.emun.PaymentType;

public class PaymentDetail {
    private PaymentType paymentProvider;

    public PaymentType getPaymentProvider() {
        return paymentProvider;
    }

    public void setPaymentProvider(PaymentType paymentProvider) {
        this.paymentProvider = paymentProvider;
    }
}
