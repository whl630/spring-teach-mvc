package com.service.impl;

import com.dao.EmployeeDao;
import config.simple.SimpleConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SimpleConfigTest {

    @Test
    public void testSimpleConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfig.class);
        EmployeeServiceImpl employeeService = context.getBean(EmployeeServiceImpl.class);
        System.out.println(employeeService);


        EmployeeDao dao = context.getBean(EmployeeDao.class);
        System.out.println(dao);
    }



}
