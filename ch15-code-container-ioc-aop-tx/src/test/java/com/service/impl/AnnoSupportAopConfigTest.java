package com.service.impl;

import com.service.EmployeeService;
import config.annosupport.AnnoSupportAopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class AnnoSupportAopConfigTest {

    @Test
    public void testSimpleConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnoSupportAopConfig.class);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.update();
    }



}
