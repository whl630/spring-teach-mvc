package com.test;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/22
 */
public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();
        System.out.println("-----debug: employee = " + employee);

      /*  EmployeeDaoImpl dao = new EmployeeDaoImpl();
        EmployeeServiceImpl service = new EmployeeServiceImpl();
        service.setDao(dao);

        Employee employee = service.getById();
        System.out.println("-----debug: employee = " + employee);

*/


       /* UserDao dao = new UserDaoImpl1();
        UserServiceImpl service = new UserServiceImpl();
        service.setDao(dao);


        service.update();*/
    }
}


interface UserService {
    void update();
}

interface UserDao {
    void update();
}

class UserDaoImpl1 implements UserDao {
    @Override
    public void update() {
        System.out.println("userdao1");
    }
}

class UserDaoImpl2 implements UserDao {
    @Override
    public void update() {
        System.out.println("userdao222");
    }
}

class UserServiceImpl implements UserService {
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void update() {
        dao.update();
    }
}