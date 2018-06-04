package com.smm.service;

import com.smm.mapper.UserDTOToUserMapperFunction;
import com.smm.model.User;
import com.smm.model.UserDetail;
import com.smm.model.dto.UserDTO;
import com.smm.repository.UserDetailRepository;
import com.smm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDetailRepository userDetailRepository;
    private final UserRepository userRepository;

    public boolean addUser(UserDTO userDTO) {
        User user = new UserDTOToUserMapperFunction().apply(userDTO);
        UserDetail detail = new UserDetail();
        String refCode = userDTO.getRefCode();
        if(!Strings.isEmpty(refCode)) {
            UserDetail userDetail = userDetailRepository.getByReferCode(refCode);
            if(userDetail != null) {
                User from = userDetail.getFrom();
                detail.setFrom(from);
            }
        }
        detail.setReferCode(RandomStringUtils.randomAlphabetic(8));
        userDetailRepository.save(detail);
        user.setUserDetail(detail);
        User save = userRepository.save(user);

        return !Strings.isEmpty(save.getId());
    }


    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
