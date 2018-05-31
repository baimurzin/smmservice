package com.smm.vendor.smm.impl.smmlaba;

import com.smm.vendor.smm.impl.smmlaba.messages.APIMEssageBalance;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageServices;
import com.smm.vendor.smm.impl.smmlaba.messages.APIMessageTest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface APIClient {

    @RequestLine("POST /?action=test&apikey={apikey}&username={username}")
    APIResponse<APIMessageTest> test(@Param("apikey") String apikey,
                                     @Param("username") String email);

    @RequestLine("POST /?action=balance&apikey={apikey}&username={username}")
    APIResponse<APIMEssageBalance> balance(@Param("apikey") String apikey,
                                           @Param("username") String email);

    @RequestLine("POST /?action=services&apikey={apikey}&username={username}")
    APIResponseMessageList<APIMessageServices> services(@Param("apikey") String apikey,
                                             @Param("username") String email);


    @RequestLine("POST /?action=services&apikey={apikey}&username={username}&service={service}")
    APIResponseMessageList<APIMessageServices> serviceById(@Param("apikey") String apikey,
                                                @Param("username") String email,
                                                @Param("service") String service);


}
