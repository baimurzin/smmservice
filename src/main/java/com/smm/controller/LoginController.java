package com.smm.controller;

import com.smm.model.User;
import com.smm.repository.UserRepository;
import com.smm.service.UserService;
import com.smm.tools.SecurityContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String login(
            @RequestParam(value = "error", required = false) String error,
            ModelMap map) {
        if(error != null) {
            map.addAttribute("error", "Invalid username or password!");
        }
        User user = SecurityContextUtil.getAuthUser();
        if(user != null)
            return "redirect:/";
        else
            return "login";
    }

}
