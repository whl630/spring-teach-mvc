package com.service.impl;

import config.HelloConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class EmployeeServiceImplTest {

    @Test
    public void testCodeHelloWorld(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        employeeService.update();

    }


    @Test
    public void testCodeHelloWorld2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);


        EmployeeServiceImpl2 employeeService = context.getBean("employeeServiceImpl2",EmployeeServiceImpl2.class);
        employeeService.update();

    }


    @Test
    public void testCodeHelloWorld3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        employeeService.update();


        EmployeeServiceImpl2 employeeService2 = context.getBean("employeeServiceImpl2",EmployeeServiceImpl2.class);
        employeeService2.update();

    }
}
