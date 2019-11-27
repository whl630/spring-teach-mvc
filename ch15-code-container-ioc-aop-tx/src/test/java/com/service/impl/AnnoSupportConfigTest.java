package com.service.impl;

import config.annosupport.AnnoSupportConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class AnnoSupportConfigTest {

    @Test
    public void testSimpleConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnoSupportConfig.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        employeeService.update();
    }



}
