package com.service.impl;

import com.service.EmployeeService;
import config.multi.DaoConfig;
import config.multi.ServiceConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SpringMultiConfigTest {

    @Test
    public void testSpringContainer(){
//这里提供2个类作为构造函数的参数,就不需要在serviceConfig类上添加Import注解
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class,ServiceConfig.class);

        EmployeeService service = context.getBean(EmployeeService.class);
        service.update();


    }


    @Test
    public void testSpringContainer2(){
// 需要在ServiceConfig上添加Import注解
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

        EmployeeService service = context.getBean(EmployeeService.class);
        service.update();


    }



}
