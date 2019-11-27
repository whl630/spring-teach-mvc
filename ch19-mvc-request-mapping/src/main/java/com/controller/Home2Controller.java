package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/11/11
 */
@Controller
@RequestMapping("/dept")
public class Home2Controller {
    @RequestMapping("/list")
    public String index(){
        return "index";
    }



}
