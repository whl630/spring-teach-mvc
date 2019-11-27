package com.service.impl;

import com.parentchild.UserService;
import config.simple.SimpleParentChildConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author cj
 * @date 2019/11/5
 */




public class SimpleParentChildConfigTest {

    @Test
    public void testSimpleParentChildConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleParentChildConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("-----debug: name = " + name);
        }

        Map<String,UserService> maps =  context.getBeansOfType(UserService.class);
        for (Map.Entry<String, UserService> entry : maps.entrySet()) {
            System.out.println("-----debug: entry.getKey() = " + entry.getKey());
            System.out.println("-----debug: entry.getValue() = " + entry.getValue());
        }

    }

    @Test
    public void testSimpleParentChildConfig2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleParentChildConfig.class);
        UserService service = context.getBean(UserService.class);
        service.test();

    }



}
