package com.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cj
 * @date 2019/11/14
 */
@Controller
@RequestMapping("/display")

/**
 * mvc理念:view对象永远不能直接访问,只能直接访问控制器
 * 由控制器去访问view(而且按照servlet jsp技术,基本就是转发到视图)
 *
 * 按照这个理念,在这里只是显示视图,不要想着转发与重定向的问题.直接理解为
 * 把视图打开以响应用户请求.
 */
public class DisplayViewController {
///////////////////////////////////////
    ///   显示视图
    /////////////////////////
    @RequestMapping("/demo1")
    public String demo1(){
        return "view";
    }



    @RequestMapping("/demo2")
    public ModelAndView demo2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view");
        return mav;
    }


}
