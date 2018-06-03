package com.smm.vendor.smm.impl.smmlaba;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@ToString
public class APIResponseMessageList<T> {
    private String result;
    private String error;
    private List<T> message;
}