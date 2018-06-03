package com.smm.vendor.smm.impl.smmlaba.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class APIMessageServices {
    private String service;
    private String category;
    @JsonProperty("product_name")
    private String productName;
    private String price;
    private List<APIMessageServicesPrices> params;
}
