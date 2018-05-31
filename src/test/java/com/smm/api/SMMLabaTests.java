package com.smm.api;


import com.smm.configuration.AppConfig;
import com.smm.model.SMMAPIType;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.SMMAPIStrategyFactory;
import com.smm.vendor.smm.impl.smmlaba.APIResponse;
import com.smm.vendor.smm.impl.smmlaba.APIResponseMessageList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class SMMLabaTests {

    private final static SMMAPIType SMMLABA_API_NAME = SMMAPIType.SMMLABA;

    @Autowired
    private SMMAPIStrategyFactory smmapiStrategyFactory;
    private SMMAPIStrategy<APIResponse, APIResponseMessageList> smmapiStrategy;

    @Before
    public void setUp() {
        smmapiStrategy = smmapiStrategyFactory.getSMMAPIStrategy(SMMLABA_API_NAME);
    }

    @Test
    public void smmlabaAPIshouldWorksTest() {
        HashMap<String, String> params = new HashMap<>();
        APIResponse result = smmapiStrategy.isActive(params);
    }

    @Test
    public void testSmmlabaAPIBalance() {
        HashMap<String, String> params = new HashMap<>();
        APIResponse result = smmapiStrategy.getBalance(params);
    }

    @Test
    public void testSmmlabaAPIServices() {
        APIResponseMessageList result = smmapiStrategy.getServices();
    }

    @Test
    public void testSmmlabaAPIService() {
        APIResponseMessageList result = smmapiStrategy.getService("askfm");
    }
}
