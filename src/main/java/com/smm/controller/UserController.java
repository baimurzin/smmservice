package com.smm.controller;


import com.smm.mapper.UserDTOToUserMapperFunction;
import com.smm.model.User;
import com.smm.model.dto.UserDTO;
import com.smm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        if (Strings.isEmpty(userDTO.getEmail())
                || Strings.isEmpty(userDTO.getPassword())
                || Strings.isEmpty(userDTO.getPasswordRepeat())) {
            return ResponseEntity.badRequest().build();
        }

        if (!userDTO.getPassword().equals(userDTO.getPasswordRepeat())) {
            return ResponseEntity.badRequest().build();
        }

        if(userService.addUser(userDTO)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
