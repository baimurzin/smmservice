package com.smm.vendor.smm.impl.smmlaba.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
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
