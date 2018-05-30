package com.smm.state;

import com.smm.model.Order;

public class SuccessCompletedOrderState extends OrderState {

    public SuccessCompletedOrderState(Order order) {
        super(order);
    }

    @Override
    public String onCreated() {
        return null;
    }

    @Override
    public Object onProgress() {
        return null;
    }

    @Override
    public String onSuccessCompleted() {
        return null;
    }

    @Override
    public String onError() {
        return null;
    }
}
