package com.smm.vendor.smm;

import com.smm.model.other.APIBalance;
import com.smm.model.other.APIOrderStatus;
import com.smm.model.Order;
import com.smm.model.Service;

import java.util.List;
import java.util.Map;

public interface SMMAPIStrategy<T, V> {

    T addOrder(Order order);
    T isActive(Map<String, String> params);
    T getBalance(Map<String, String> params);
    T getOrderStatus(long orderId);
    V getServices();
    V getService(String name);
}
