package com.smm.state;

import com.smm.model.Order;

public abstract class OrderState<T> {

    public T order;

    public OrderState(T order) {
        this.order = order;
    }

    /**
     * Was created new order
     * @return
     */
    public abstract T onCreated();

    /**
     * Order's progress has been started,
     * added to queue in external service
     * @return
     */
    public abstract T onProgress();

    /**
     * Order completed successfully
     * @return
     */
    public abstract T onSuccessCompleted();

    /**
     * Order failed
     * @return
     */
    public abstract T onError();
}
