package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author cj
 * @date 2019/11/7
 */

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String handle(){
        System.out.println("index------");

       //这里的hello是逻辑视图的名字,靠配置的视图解析器解析为真正的视图,比如jsp文件
        return "hello";
    }


    @RequestMapping("/index2")
    public ModelAndView handle2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("msg", "mvc");
        return mav;
    }
}
