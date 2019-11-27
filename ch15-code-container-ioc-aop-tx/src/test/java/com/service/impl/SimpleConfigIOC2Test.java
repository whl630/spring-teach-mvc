package com.service.impl;

import config.simple.SimpleConfigIOC;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SimpleConfigIOC2Test {

    @Test
    public void testSimpleConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfigIOC.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        employeeService.update();



    }



}
