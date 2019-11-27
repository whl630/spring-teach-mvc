package com;

import com.service.DeptService;
import com.service.DeptServiceImpl;
import com.service.EmployeeServiceImpl;
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
        System.out.println("-----debug: service.getClass() = " + service.getClass());
        service.insert();
        System.out.println("--------------------------");
        //service.update();
        DeptService deptService = context.getBean("deptService", DeptService.class);
        deptService.delete();

        System.out.println("--------------------------");
        DeptServiceImpl deptService2 = context.getBean("deptService", DeptServiceImpl.class);
        deptService2.delete();
    }
}
