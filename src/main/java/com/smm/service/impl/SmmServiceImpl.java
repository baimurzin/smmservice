package com.smm.service.impl;

import com.smm.model.Order;
import com.smm.model.emun.SMMAPIType;
import com.smm.service.SmmService;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.SMMAPIStrategyFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmmServiceImpl implements SmmService {

    @Autowired
    private SMMAPIStrategyFactory smmapiStrategyFactory;

    @Override
    public void addOrder(Order order) {
        // some logic here to decide which API will be used
        try {
            SMMAPIStrategy smmapiStrategy = smmapiStrategyFactory.getSMMAPIStrategy(SMMAPIType.SMMLABA);
            smmapiStrategy.addOrder(order);
        } catch (NoUniqueBeanDefinitionException e) {
            throw new UnsupportedOperationException("Provided smm vendor not supported", e);
        }
    }
}
