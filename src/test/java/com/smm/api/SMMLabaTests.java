package com.smm.api;


import com.smm.configuration.AppConfig;
import com.smm.model.enums.SMMAPIType;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.SMMAPIStrategyFactory;
import com.smm.vendor.smm.impl.smmlaba.APIResponse;
import com.smm.vendor.smm.impl.smmlaba.APIResponseMessageList;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMEssageBalance;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServices;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageStatus;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

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
        APIResponse<APIMessageTest> result = smmapiStrategy.isActive(params);
        assertEquals("ok",result.getMessage().getTest());
    }

    @Test
    public void testSmmlabaAPIBalance() {
        HashMap<String, String> params = new HashMap<>();
        APIResponse<APIMEssageBalance> result = smmapiStrategy.getBalance(params);
        assertThat(Double.parseDouble(result.getMessage().getBalance()), instanceOf(Double.class));
    }

    @Test
    public void testSmmlabaAPIServices() {
        APIResponseMessageList<APIMessageServices> result = smmapiStrategy.getServices();
        assertNotNull(result.getMessage());
    }

    @Test
    public void testSmmlabaAPIService() {
        APIResponseMessageList<APIMessageServices> result = smmapiStrategy.getService("askfm");
        assertNotNull(result.getMessage());
    }

    @Test
    public void testSmmlabaAPIGetOrderStatus() {
        APIResponse<APIMessageStatus> result = smmapiStrategy.getOrderStatus(3537093L);
        assertNotNull(result.getMessage());
    }
}
