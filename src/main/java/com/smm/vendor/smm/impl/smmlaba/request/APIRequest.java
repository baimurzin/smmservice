package com.smm.vendor.smm.impl.smmlaba.request;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class APIRequest {

    private Map<String, Object> requestParametersMap;

    private APIRequest() {}

    public static class Builder {
        private Map<String, Object> requestMap = new HashMap<>();

        public Builder addApiEmail(String email) {
            requestMap.put("username", email);
            return this;
        }

        public Builder addApiToken(String token) {
            requestMap.put("apikey", token);
            return this;
        }

        public Builder withService(String serviceName) {
            requestMap.put("service", serviceName);
            return this;
        }

        public Builder withCustomParam(String key, Object value) {
            requestMap.put(key, value);
            return this;
        }

        public APIRequest build() {
            APIRequest apiRequest = new APIRequest();
            apiRequest.requestParametersMap = Collections.unmodifiableMap(requestMap);
            return apiRequest;
        }
    }
}
