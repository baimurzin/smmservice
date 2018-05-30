package com.smm.model;

import com.smm.state.OrderCreatedState;
import com.smm.state.OrderState;

public class Order {

    private OrderState orderState;

    public Order() {
        //order created
        this.orderState = new OrderCreatedState(this);
    }
}
