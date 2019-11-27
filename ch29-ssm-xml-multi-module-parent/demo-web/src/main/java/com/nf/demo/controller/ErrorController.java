package com.nf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/11/21
 */
@Controller
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        return "404";
    }
}
