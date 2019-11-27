package com;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author cj
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean("employeeService", EmployeeService.class);

        List<Employee> emps = service.getAll(2, 3);

        for (Employee emp : emps) {
            System.out.println("-----debug: emp = " + emp);
        }
    }
}
