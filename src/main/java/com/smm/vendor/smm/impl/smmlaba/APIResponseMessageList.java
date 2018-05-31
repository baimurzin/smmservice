package com.smm.vendor.smm.impl.smmlaba;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class APIResponseMessageList<T> {
    private String result;
    private String error;
    private List<T> message;
}