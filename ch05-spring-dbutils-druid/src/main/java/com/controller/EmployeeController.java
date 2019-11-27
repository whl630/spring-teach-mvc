package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import com.spring.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cj
 * @date 2019/10/22
 */
@WebServlet("/index")
public class EmployeeController extends HttpServlet {



   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //下面这种写法,如果servlet多了,就会创建很多个spring容器对象
        //那么相应的也会导致被spring容器管理的bean不具备单例的情况
        //有多少个spring容器,单例的bean就会有多少个,所有spring容器应该只需要一个就可以了.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service =  context.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();

        req.setAttribute("emp", employee);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }*/


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = ApplicationContextUtil.getApplicationContext(req);
        EmployeeService service =  context.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();

        req.setAttribute("emp", employee);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
