package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/23
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceImpl service = context.getBean("employeeService", EmployeeServiceImpl.class);
       //service.insert();
       // service.update();

        int result = service.add(5, 6);
        System.out.println("-----debug: result = " + result);
    }
}
