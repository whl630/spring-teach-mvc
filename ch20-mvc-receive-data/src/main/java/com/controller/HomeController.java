package com.controller;

import com.entity.Emp;
import com.entity.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * spring mvc支持以下类型的数据绑定(dataBinder)
 *
 * 1.基本类型
 * 2.包装类型
 * 3.复杂类型(自己写的普通的bean)
 * 4.list
 * 5.map
 * 6.set
 * @author cj
 * @date 2019/11/11
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/wrapper")
    public String index(String abc,Integer pageNo){
        System.out.println("---" + abc);
        System.out.println("-----debug: pageNo = " + pageNo);
        return "index";
    }

    @GetMapping("/simple")
    public String index(int pageNo){

        System.out.println("-----debug: pageNo = " + pageNo);
        return "index";
    }


    // 你没有传递参数时,会用默认值
    // 当传递了参数,但不能转换为整数时,报400的错误(请求数据有问题)
    //因为设置了value,所以传递的参数就以page为准,不以方法的参数名为准了

    //RequestParam注解的本质作用就是从请求数据(request.getParameter)中获取数据来赋值给修饰的方法参数
    @GetMapping("/simple2")
    public String index2(@RequestParam(value="page",required = false,defaultValue = "1") int pageNo){

        System.out.println("-----debug: pageNo = " + pageNo);
        return "index";
    }


    @GetMapping("/simple/page/{pageNo}")
    public String index3(@PathVariable("pageNo") int pageNo){

        System.out.println("-----debug: pageNo = " + pageNo);
        return "index";
    }
    @GetMapping("/complex")
    public String index(Emp emp){

        System.out.println("-----debug: emp = " + emp);
        return "index";
    }

// 下面这种写法是不能接收到list的数据的.
    //原因是spring mvc比较水
    /*@GetMapping("/list")
    public String index(List<Emp> emp){

        System.out.println("-----debug: emp = " + emp);
        return "index";
    }*/


    @GetMapping("/list")
    public String index(EmpVO empVO){

        System.out.println("-----debug: empVO = " + empVO);
        return "index";
    }


    @GetMapping("/array")
    public String index(String[] name){

        System.out.println("-----debug: name = " + name);
        return "index";
    }

    /**
     * RequestMapping注解修饰的方法,支持以下一些类型作为参数
     * 比如:
     * 1.HttpServletRequest
     * 2.HttpServletResponse
     * 3.HttpSession等等
     * 具体就看官方文档:搜索HandlerMethod,去找表格
     * @param request
     * @return
     */
    @GetMapping("/req")
    public String index(HttpServletRequest request){


        return "index";
    }
}
