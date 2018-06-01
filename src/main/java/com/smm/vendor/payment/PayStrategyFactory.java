package com.smm.vendor.payment;

import com.smm.model.emun.PaymentType;

public interface PayStrategyFactory {
    PayStrategy getPaymentStrategy(PaymentType paymentType);
}
