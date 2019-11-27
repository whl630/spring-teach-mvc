package com;

import com.service.XXXManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/30
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XXXManager manager = context.getBean("manager", XXXManager.class);
        try {
            manager.demo();
        } catch (Throwable throwable) {
            System.out.println("-----debug: throwable.getClass().getName() = " + throwable.getClass().getName());
        }

    }
}
