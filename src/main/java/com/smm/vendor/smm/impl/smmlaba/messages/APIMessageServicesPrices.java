package com.smm.vendor.smm.impl.smmlaba.messages;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class APIMessageServicesPrices {
    private String name;
    private String param;
    private Integer required;
    private String valid;
    private List<String> values;
}
