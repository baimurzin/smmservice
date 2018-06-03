package com.smm.vendor.smm.impl.smmlaba;

import lombok.*;

@Data
@NoArgsConstructor @ToString
public class APIResponse<T> {
    private String result;
    private String error;
    private T message;
}
