package com.smm.vendor.payment;

import com.smm.model.enums.PaymentType;

public interface PayStrategyFactory {
    PayStrategy getPaymentStrategy(PaymentType paymentType);
}
