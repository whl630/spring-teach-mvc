package com.service.impl;

import com.dao.impl.EmployeDaoImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SpringContainerTest {

    @Test
    public void testSpringContainer(){
        //这个容器类,可以手动的往里面注册bean,而且不一定是配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EmployeDaoImpl.class);
        context.register(EmployeeServiceImpl.class);
        context.refresh();

        EmployeeServiceImpl service = context.getBean(EmployeeServiceImpl.class);
        service.update();

    }


    @Test
    public void testSpringContainer2(){
        //这个容器类,可以手动的往里面注册bean,而且不一定是配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com");
        context.refresh();

        EmployeeServiceImpl service = context.getBean(EmployeeServiceImpl.class);
        service.update();

    }


}
