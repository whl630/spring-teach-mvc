package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author cj
 * @date 2019/11/12
 */

@Controller
@RequestMapping("/formatter")
public class Date2FormatterController {

    @Autowired(required = false)
    private ConversionService conversionService;


    /**
     * WebDataBinder是DataBinder(数据绑定)的子类
     * 数据绑定类的作用主要有以下几个:
     * 1.类型转换(主要是把字符串类型转换为其它类型,比如Integer,Date等等
     * 2.校验(判断数据是否符合要求,比如密码长度是否有8位,年龄是否在合理区间)
     * 3.处理绑定结果:可以得到哪些绑定有问题.
     *
     * @param dataBinder
     * @InitBinder:初始化绑定器,给绑定器添加一些定制内容,比如格式化器. 被InitBinder注解修饰的方法的要求
     * 1.方法名是任意的
     * 2.方法的返回值必须void
     * 3.方法的参数与RequestMapping修饰的方法参数类似
     * 4.方法的参数可以有多个
     * <p>
     * 但是一般用InitBinder修饰的方法,其参数主要写这么几个
     * 1.WebDataBinder
     * 2.Locale
     * 3.WebRequest
     * <p>
     * <p>
     * Formatter:就是用来把字符串转换其它类型或者反之,
     * 所以Formatter特别适合在servlet环境下使用
     * Converter:用来在任意两个类型之间进行转换
     * 这2个接口是在spring 3.0之后才出现

     * 以前spring进行类型转换使用jdk(主要用在窗口程序开发中)PropertyEditor体系
     * 这种PropertyEditor体系就是stirng->其它类型的转换,因为这种体系有2个主要的缺点
     * 1.线程不安全
     * 2.跟UI的东西耦合
     *
     * 所以spring 3.0就推出了自己的转换体系,以Formmatter与Converter以及相关的注解为代表
     * 为了方便这2个接口的使用,就有一个转换服务接口:ConversionService.
     *
     * DataBinder用到了PropertyEditor与ConverService这2个体系,在TypeConverterDelegate.convertIfNecessary()
     * 方法中可以看到基本的使用逻辑.
     *
     *
     * InitBinder注解对绑定器做的设定,只在本控制器有效,
     * 也就是说只对本控制器的所有请求方法是有效的,但是对其它控制器的
     * 请求方法是无效
     * <p>
     * 所以需要掌握如何注册全局的格式化器.
     * 1.利用ControllerAdvice注解
     * 2.在spring 配置元数据中设定
     */
    @InitBinder
    public void xxxx( WebDataBinder dataBinder) {

        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern("yyyy-MM-dd");
        dataBinder.addCustomFormatter(dateFormatter);
    }


    @GetMapping("/date2")
    public String receiveDate2(Date date) {

        System.out.println("-----debug: date = " + date);
        return "index";
    }

}
