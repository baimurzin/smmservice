package com.smm.vendor.payment.impl;

import com.smm.vendor.payment.PayStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("robokassa")
public class RobokassaProvider implements PayStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobokassaProvider.class);

    @Override
    public void pay() {
        LOGGER.info("Paid with " + this.getClass().getSimpleName());
    }
}
