package com.smm.vendor.smm.impl.smmlaba;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class APIResponse<T> {
    private String result;
    private String error;
    private T message;
}
