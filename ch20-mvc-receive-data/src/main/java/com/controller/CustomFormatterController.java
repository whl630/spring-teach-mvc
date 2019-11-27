package com.controller;

import com.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cj
 * @date 2019/11/12
 */

@Controller
@RequestMapping("/formatter")
public class CustomFormatterController {


    /**
     * 请求地址 :/formatter/emp?xxx=chen,jun就可以转换成功
     * 通过指定RequestParam就明确表明把请求参数中xxx的值转换为一个Emp
     * 这是必须指定的,否则会导致Emp类型无法绑定,也就用不到自定义的Formatter了
     * (回忆一下:Emp类型绑定时,请求数据只需要出现Emp的属性名即可id=1&username=abc)
     *
     * @param emp
     * @return
     */
    @GetMapping("/emp")
    public String receiveEmp(@RequestParam("xxx") Emp emp) {

        System.out.println("-----debug: emp = " + emp);
        return "index";
    }
}
