package com.smm.vendor.smm.impl.smmlaba.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class APIMessageServicesPrices {
    private String name;
    private String param;
    private Integer required;
    private String valid;
    private String values;
}
