package com.smm.vendor.payment;

import com.smm.model.Order;

public interface PayStrategy {

    Object pay(Order order);
}
