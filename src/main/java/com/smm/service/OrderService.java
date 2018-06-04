package com.smm.service;

import com.smm.model.Order;
import com.smm.model.other.OrderDetail;
import com.smm.model.other.PaymentDetail;

public interface OrderService {

    void checkoutOrder(PaymentDetail payStrategy);

    /**
     * Someone order new product ex. Instagram 100 likes
     * find this product in product factory, collect customer detail from
     * orderDetail and create new order from these parameters.
     * @param orderDetail
     * @return new just created order
     */
    Order orderProduct(OrderDetail orderDetail);
}
