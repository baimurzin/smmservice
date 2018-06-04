package com.smm.vendor.smm;

import com.smm.model.other.APIBalance;
import com.smm.model.other.APIOrderStatus;
import com.smm.model.Order;
import com.smm.model.Service;

import java.util.List;

public interface SMMAPIStrategy {

    Order addOrder(Order order);
    boolean isActive();
    APIBalance getBalance();
    APIOrderStatus getOrderStatus(long orderId);
    List<Service> getServices();
}
