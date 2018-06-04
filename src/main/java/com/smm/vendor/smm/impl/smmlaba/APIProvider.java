package com.smm.vendor.smm.impl.smmlaba;

import com.smm.model.Order;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMEssageBalance;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServices;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageStatus;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageTest;
import com.smm.vendor.smm.impl.smmlaba.request.APIRequest;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("smmlaba")
public class APIProvider implements SMMAPIStrategy<APIResponse,APIResponseMessageList<APIMessageServices>> {

    private final static Logger LOGGER = LoggerFactory.getLogger(APIProvider.class);

    private final static String SMMLABA_API_URL = "https://smmlaba.com/vkapi/v1";
    private final static String SMMLABA_API_KEY = "70e6c7ad4965fc74e8f788ecbd7da942140cd97e";
    private static final String SMMLABA_API_EMAIL = "baimurzin.719@gmail.com";

    private final APIRequest.Builder apiRequestBaseBuilder = new APIRequest.Builder().addApiEmail(SMMLABA_API_EMAIL)
            .addApiToken(SMMLABA_API_KEY);

    private final APIClient smmLabaClient = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(APIClient.class, SMMLABA_API_URL);


    @Override
    public APIResponse addOrder(Order order) {
        LOGGER.info("Order added in queue in " + this.getClass().getSimpleName());

        return null;
    }

    @Override
    public APIResponse isActive(Map<String, String> params) {
        APIRequest request = apiRequestBaseBuilder.build();
        APIResponse<APIMessageTest> response = smmLabaClient.test(request.getRequestParametersMap());
        LOGGER.info(response.toString());
        return response;
    }

    @Override
    public APIResponse getBalance(Map<String, String> params) {
        APIRequest request = apiRequestBaseBuilder.build();
        APIResponse<APIMEssageBalance> response = smmLabaClient.balance(request.getRequestParametersMap());
        LOGGER.info(response.toString());
        return response;
    }

    @Override
    public APIResponse<APIMessageStatus> getOrderStatus(long orderId) {
        APIRequest request = apiRequestBaseBuilder.withCustomParam("orderid", orderId).build();
        APIResponse<APIMessageStatus> apiMessageStatusAPIResponse = smmLabaClient.checkOrderStatus(request.getRequestParametersMap());
        LOGGER.info(apiMessageStatusAPIResponse.toString());
        return apiMessageStatusAPIResponse;
    }

    @Override
    public APIResponseMessageList<APIMessageServices> getServices() {
        APIRequest request = apiRequestBaseBuilder.build();
        APIResponseMessageList<APIMessageServices> services = smmLabaClient.services(request.getRequestParametersMap());
        LOGGER.info(services.toString());
        return services;
    }

    @Override
    public APIResponseMessageList<APIMessageServices> getService(String name) {
        APIRequest request = apiRequestBaseBuilder.withService(name).build();
        APIResponseMessageList<APIMessageServices> response = smmLabaClient.services(request.getRequestParametersMap());
        LOGGER.info(response.toString());
        return response;
    }
}
