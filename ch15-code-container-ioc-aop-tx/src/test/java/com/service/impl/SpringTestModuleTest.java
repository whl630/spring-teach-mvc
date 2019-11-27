package com.service.impl;

import com.service.EmployeeService;
import config.annosupport.AnnoSupportAopConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cj
 * @date 2019/11/5
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnoSupportAopConfig.class)
public class SpringTestModuleTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private EmployeeService service;
    @Test
    public void testSimpleConfig(){
        System.out.println(context.getClass().getName());
      //  ApplicationContext context = new AnnotationConfigApplicationContext(AnnoSupportAopConfig.class);
       // EmployeeService employeeService = context.getBean(EmployeeService.class);
       // employeeService.update();
        service.update();
    }



}
