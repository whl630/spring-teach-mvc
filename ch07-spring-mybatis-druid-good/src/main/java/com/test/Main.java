package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author cj
 * @date 2019/10/23
 */
public class Main {
    public static void main(String[] args) throws IOException {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();
        System.out.println("-----debug: employee = " + employee);*/
       testSpringResource();
    }

    private static void testSpringResource() {
        //通过在SpringResourceTest类中输出Resource的类型,就知道实际读取配置文件之后转换的类型
        //然后读取这些类型的源代码中的注释就知道它的作用,比如UrlResource的注释就知道它用在了ResourceArrayPropertyEditor里面了.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_resource_test.xml");
        SpringResourceTest resourceTest = context.getBean("resourceTest", SpringResourceTest.class);
        System.out.println("-----debug: resourceTest = " + resourceTest);
    }
}
