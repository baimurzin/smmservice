package com.smm.model.dto;


import lombok.Data;

@Data
public class UserDTO {

    private String email;

    private String password;
    private String passwordRepeat;
    private String refCode;
}
