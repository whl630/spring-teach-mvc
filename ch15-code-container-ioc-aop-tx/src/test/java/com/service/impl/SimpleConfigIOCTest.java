package com.service.impl;

import config.simple.SimpleConfigIOC2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SimpleConfigIOCTest {

    @Test
    public void testSimpleConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfigIOC2.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        employeeService.update();



    }



}
