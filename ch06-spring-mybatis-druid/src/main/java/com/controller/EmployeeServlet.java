package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import com.spring.ApplicationContextHolder;

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
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService service =  ApplicationContextHolder.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();

        req.setAttribute("emp", employee);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
