package com.controller;

import com.entity.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;

/**
 * @author cj
 * @date 2019/11/16
 */
@Controller
//@ResponseBody

//@RestController
public class HomeController {

    @RequestMapping("/index")
    //@ResponseBody
    public String index(){
        return "index";
    }

    /**
     * ResponseBody注解的含义:
     * 1. 就是把方法的返回类型交给一个特殊的特性去处理(HttpMessageConverter)
     * 2.处理的结果直接放到http响应体里面
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EmpVO list() throws ParseException {

        EmpVO empVO = new EmpVO(1, "aaa", new Date());
        return empVO;
    }

    /**
     * RequestBody注解,就是把请求传递过来的请求体
     * 中的数据利用消息转换器,转换为被它修饰的参数的类型
     * @param empVO
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public EmpVO insert(@RequestBody EmpVO empVO) {
        System.out.println("-----debug: empVO = " + empVO);
        EmpVO result = new EmpVO(1, "server", new Date());
        return result;
    }


    /**
     * 不加@RequestBody表示使用传统的数据绑定来绑定参数值,
     * 对应jsp中的insert2按钮的案例
     * @param empVO
     * @return
     */
    @RequestMapping("/insert2")
    @ResponseBody
    public EmpVO insert2( EmpVO empVO) {
        System.out.println("-----debug: empVO = " + empVO);
        EmpVO result = new EmpVO(2, "server2", new Date());
        return result;
    }
}
