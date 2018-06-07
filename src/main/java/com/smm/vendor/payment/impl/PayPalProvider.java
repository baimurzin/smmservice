package com.smm.vendor.payment.impl;

import com.smm.model.Order;
import com.smm.vendor.payment.PayStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPalProvider implements PayStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayPalProvider.class);

    @Override
    public Object pay(Order order) {
        LOGGER.info("Paid with " + this.getClass().getSimpleName());
        return null;
    }
}
