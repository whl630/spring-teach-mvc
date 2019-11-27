package com.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/** 这个ControllerAdvice注解里面主要是写3种类型的代码
 * 1.initBinder
 * 2.ModelAttribute
 * 3.ExceptionHandler
 *
 * ControllerAdvice有一些属性,可以用来限制
 * 此控制器通知可以在哪些控制上有效
 * @ControllerAdvice("com.controller.front")
 * @author cj
 * @date 2019/11/18
 */

@ControllerAdvice
public class SystemControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ae){
        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(RuntimeException re){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("err", re.getMessage());
        return mav;
    }
}
