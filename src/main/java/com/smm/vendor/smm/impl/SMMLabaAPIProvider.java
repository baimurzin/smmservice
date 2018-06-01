package com.smm.vendor.smm.impl;

import com.smm.model.other.APIBalance;
import com.smm.model.other.APIOrderStatus;
import com.smm.model.Order;
import com.smm.model.Service;
import com.smm.vendor.smm.SMMAPIStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("smmlaba")
public class SMMLabaAPIProvider implements SMMAPIStrategy {

    private final static Logger LOGGER = LoggerFactory.getLogger(SMMLabaAPIProvider.class);

    @Override
    public Order addOrder(Order order) {
        LOGGER.info("Order added in queue in " + this.getClass().getSimpleName());
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public APIBalance getBalance() {
        return null;
    }

    @Override
    public APIOrderStatus getOrderStatus(long orderId) {
        return null;
    }

    @Override
    public List<Service> getServices() {
        return null;
    }
}
