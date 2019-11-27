package com.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

/** 加了ControllerAdvice之后,就表明
 * 这个类是所有控制器的一个切面类
 *
 *
 * 被ControllerAdvice修饰的类主要作用:
 * 1.设定绑定器
 * 2.进行全局的异常处理
 * 3.ModelAttribute处理
 * **注意***:在这种类里面写的功能没什么意义
 * @author cj
 * @date 2019/11/12
 */

@ControllerAdvice
public class MyControllerAdvice {

   /*   @InitBinder
    public void xxxx(WebDataBinder dataBinder) {
        dataBinder.addCustomFormatter(new EmpFormatter());
        dataBinder.addCustomFormatter(new DateFormatter());
    }*/



}
