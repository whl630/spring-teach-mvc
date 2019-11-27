package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author cj
 * @date 2019/11/11
 */
@Controller
@RequestMapping("/dept")
public class Home5Controller {
//: list/page/100
    // PathVariable
    @PostMapping("/list/page/{pageNo:\\d}")
    public String index2(){
        return "index";
    }

}
