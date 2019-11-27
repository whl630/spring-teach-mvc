package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/11/11
 */
@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * requestMapping它是支持ant地址格式
     * @return
     */
    @RequestMapping("/**/*index")
    public String index2(){
        return "index";
    }

    /**
     * 这种配置方法,就是默认处理方法
     * 英文fallback(备胎)
     * @return
     */
    @RequestMapping("*")
    public String index3(){
        return "index";
    }

    @RequestMapping(value = {"/index","index3"})
    public String index4(){
        return "index";
    }
}
