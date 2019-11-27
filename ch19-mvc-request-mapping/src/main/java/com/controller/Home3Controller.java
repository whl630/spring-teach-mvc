package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author cj
 * @date 2019/11/11
 */
@Controller
public class Home3Controller {
    /**
     * RequestMaping注解的其它属性,都是用来限缩此
     * 方法可以处理的请求
     * 比如method指定为get的话,那么此方法只能处理get请求
     *
     *
     * 这个方法只用来处理get请求,请求的地址为/index
     *
     * 其它的属性,比如
     * params(参数),{a=5}
     * headers(请求头),
     * produces(产生,生产的意思),这个地方其实依据请求信息中的accept来限缩
     * consumes(消费的意思):就是浏览器端传过来的内容必须是某个类型
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 这个方法只用来处理post请求,请求的地址为/index
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String index2(){
        return "index";
    }


    /**
     * 下面的这个配置意思是:
     * 1.请求地址为/index2
     * 2.请求必须有参数a并且值为5
     * 3.请求头部必须有b,并且值为3
     * 4.请求accept里面必须有application/json:表示本处理方法必须响应application/json的内容
     * 5.请求必须传递的是text/html内容类型的数据
     *
     * 满足这5个条件,此方法才会处理这样的请求
     *
     * @return
     */
    @RequestMapping(value = "/index2",
            method = RequestMethod.POST,
    params = "a=5",headers = "b=3",
    produces = "application/json",
            consumes = "text/html"
    )
    public String index3(){
        //response.setContentType("application/json")
        return "index";
    }
}
