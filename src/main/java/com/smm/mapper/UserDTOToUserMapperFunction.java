package com.smm.mapper;

import com.smm.model.User;
import com.smm.model.dto.UserDTO;
import com.smm.model.enums.RoleType;
import com.smm.tools.HelperUtil;


import java.util.function.Function;

public class UserDTOToUserMapperFunction implements Function<UserDTO, User> {
    

    @Override
    public User apply(UserDTO userDTO) {

        String salt = HelperUtil.generateSalt(userDTO.getPassword().length());
        return User.builder()
                .email(userDTO.getEmail())
                .password(HelperUtil.md5(userDTO.getPassword(),
                        salt))
                .salt(salt)
                .role(RoleType.USER)
                .build();
    }


}
