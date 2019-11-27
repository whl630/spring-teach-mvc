package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author cj
 * @date 2019/11/18
 */
@Controller
public class HomeController {
@Autowired(required = false)
private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 这个地方会报404错误,controllerAdvice是不能解决
     * 就要考传统的servlet技术去解决.
     * 因为ControllerAdvice的异常处理解决的是控制器方法执行以及HandlerMapping执行产生的异常,
     * 并不解决视图解析与呈现出现的异常.
     * @return
     */
    @RequestMapping("/index1")
    public String index1(){

        return "index1";
    }
    @RequestMapping("/index2")
    public String index2(){
        throw new ArithmeticException("算术异常");
    }

    @RequestMapping("/index3")
    public String index3(){
        throw new IllegalStateException("无效状态异常");
    }
}
