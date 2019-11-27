package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author cj
 * @date 2019/11/11
 */
@Controller
@RequestMapping("/dept")
public class Home4Controller {
    /**
     * 用的比较多的是4个组合注解
     * 1.GetMapping等价于RequestMapping,然后method=RequestMethod.GET
     * 2.PostMapping
     * 3.DeleteMapping
     * 4.PutMapping
     * @return
     */
    @GetMapping("/get")
    public String index(){
        return "index";
    }

    @PostMapping("/post")
    public String index2(){
        return "index";
    }

    @DeleteMapping("/delete")
    public String index3(){
        return "index";
    }

    @PutMapping("/put")
    public String index4(){
        return "index";
    }


    @PatchMapping("/patch")
    public String index5(){
        return "index";
    }



}
