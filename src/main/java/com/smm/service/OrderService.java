package com.smm.service;

import com.smm.model.PaymentDetail;

public interface OrderService {

    void checkoutOrder(PaymentDetail payStrategy);
}
