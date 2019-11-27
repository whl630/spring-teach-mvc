package com.controller.modelattribute;

import com.vo.UserinfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @date 2019/11/14
 */

@Controller
@RequestMapping("/model")

public class ModelAttributeController {

    /**
     * 此方法的返回值放到了model对象中
     * 键值就是返回类型的名字(首字母小写)
     *
     * 1. modelAttribute注解修饰在方法上,此方法是在请求
     * 此控制器的任意一个请求方法之前都会运行.
     *
     * 但如果其键与SessionAttribute的键一样,只会在有新会话的时候才会运行,
     * 而不是每次请求都会运行
     *
     * 2 ModelAttribute修饰在方法上,一般是给请求提供一些共用的初始化数据
     * @return
     */
    @ModelAttribute("abc")
    public UserinfoVO initData(){
        UserinfoVO userinfoVO = new UserinfoVO();
        userinfoVO.setUsername("init");
        return userinfoVO;
    }
    @RequestMapping("/demo1")
    public String demo1(UserinfoVO userinfoVO, Model model){
        return "model";
    }


    /**
     *
     * 当ModelAttribute注解修饰在请求方法参数上时的作用是把被修饰参数的值
     * 保存到model中,以便视图可以使用
     *
     * 其基本运行原理如下
     * 1.从model中找数据赋值给这个参数
     * 2.依据ModelAttribute设置的键去找
     * 3.如果ModelAttribute没有设置键,就依据参数类型的名字(首字母小写)这个键去找
     * 4.如果还是找不到,就实例化一个参数类型的对象,并放入到Model
     * 5.如果没有设定binding=false,那么会进行参数的数据绑定,并且更新模型中保存的值
     * binding=false是阻止数据绑定发生
     *
     *
     *
     * @param userinfoVO
     * @param model
     * @return
     */
    @RequestMapping("/demo2")
    public String demo2(@ModelAttribute(value = "abc",binding = false) UserinfoVO userinfoVO, Model model){
        return "model";
    }



}


