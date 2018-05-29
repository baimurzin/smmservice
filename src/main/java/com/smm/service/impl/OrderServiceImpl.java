package com.smm.service.impl;

import com.smm.model.PaymentDetail;
import com.smm.service.OrderService;
import com.smm.vendor.payment.PayStrategy;
import com.smm.vendor.payment.PayStrategyFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private PayStrategyFactory payStrategyFactory;

    @Override
    public void checkoutOrder(PaymentDetail paymentDetail) {
        try {
            PayStrategy paymentStrategy = payStrategyFactory.getPaymentStrategy(paymentDetail.getPaymentProvider());
            //do smth, logs
            paymentStrategy.pay();
        } catch (NoUniqueBeanDefinitionException e) {
            throw new UnsupportedOperationException(String.format("Provided payment vendor not supported %s", paymentDetail.getPaymentProvider()), e);
        }

    }
}
