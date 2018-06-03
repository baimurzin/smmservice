package com.smm.vendor.smm.impl.smmlaba;

import com.smm.vendor.smm.impl.smmlaba.messages.APIMEssageBalance;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServices;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageStatus;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageTest;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

@Headers("Accept: application/json")
public interface APIClient {

    @RequestLine("POST /?action=test")
    APIResponse<APIMessageTest> test(@QueryMap Map<String, Object> requestBase);

    @RequestLine("POST /?action=balance")
    APIResponse<APIMEssageBalance> balance(@QueryMap Map<String, Object> requestBase);

    @RequestLine("POST /?action=services")
    APIResponseMessageList<APIMessageServices> services(@QueryMap Map<String, Object> requestBase);

    @RequestLine("POST /?action=services")
    APIResponseMessageList<APIMessageServices> addOrder(@QueryMap Map<String, Object> requestBase);

    @RequestLine("POST /?action=check")
    APIResponse<APIMessageStatus> checkOrderStatus(@QueryMap Map<String, Object> requestBase);
}
