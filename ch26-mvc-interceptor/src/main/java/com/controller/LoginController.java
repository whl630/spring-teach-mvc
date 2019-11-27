package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author cj
 * @date 2019/11/20
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, HttpSession session){
        if ("admin".equalsIgnoreCase(username)) {
            session.setAttribute("username", username);
            return "index";
        }else{
            return "redirect:login";
        }

    }
}
