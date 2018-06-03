package com.smm.vendor.smm.impl.smmlaba.messages;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class APIMessageStatus {
    private String orderid;
    private String name;
    private String service;
    private String price;
    private String status;
    private String statusText;
    private String url;
    private String count;
    private String remain;
}
