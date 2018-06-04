package com.smm.api;

import com.smm.configuration.AppConfig;
import com.smm.model.Order;
import com.smm.model.enums.PaymentType;
import com.smm.repository.OrderRepository;
import com.smm.vendor.payment.PayStrategy;
import com.smm.vendor.payment.PayStrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class RobokassaTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RobokassaTest.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PayStrategyFactory payStrategyFactory;

    @Test
    public void testGenerateUrl() {
        PayStrategy paymentStrategy = payStrategyFactory.getPaymentStrategy(PaymentType.ROBOKASSA);
        Order order = new Order();
        order.setDesc("Test");
        order.setEmail("baimurzin.719@gmail.com");
        order.setOrderSum(new BigDecimal(30.50));
        order.setInvId(1L);
        String pay = (String) paymentStrategy.pay(order);
        LOGGER.info(pay);
        orderRepository.save(order);
    }
}
