package com.smm.vendor.payment;

import com.smm.model.PaymentType;

public interface PayStrategyFactory {
    PayStrategy getPaymentStrategy(PaymentType paymentType);
}
