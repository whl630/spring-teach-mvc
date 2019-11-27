package com;

import com.service.emp.EmployeeService;
import com.service.emp.impl.AbsEmployeeServiceImpl;
import com.service.emp.impl.EmployeeServiceImpl;
import com.service.emp.impl.EmployeeServiceImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/28
 */
public class Main {
    public static void main(String[] args) {
        // testByBeanImpl();
        // testByBeanInf();
        // testMultiImpl();
        testWithinAndTargetAnnotation();
        //testAnnotation();
    }


    private static void testByBeanImpl() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceImpl employeeService = context.getBean("emp", EmployeeServiceImpl.class);
        employeeService.getAll();
        employeeService.getById();
        employeeService.deleteById();
        employeeService.xxx();
    }

    /**
     * 此方法主要以接口类型获取bean的实例,主要的目标是演示this指示器
     * <p>
     * 假定指示器为:this(com.service.emp.impl.EmployeeServiceImpl)
     * <p>
     * 1. 当proxy-target-class属性没有设置(等于false)时:
     * 动态代理类"不是"EmployeeServiceImpl的子类型,不满足this条件,
     * 所以不进行aop代理
     * 2. 当proxy-target-class=true时:
     * 动态代理类"是"EmployeeServiceImpl的子类型,满足this条件
     * 所以进行aop代理
     */
    private static void testByBeanInf() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = context.getBean("emp", EmployeeService.class);
        employeeService.getAll();
        employeeService.getById();
        employeeService.deleteById();
    }

    /**
     * 此方法主要用来演示@target与@within指示器
     *
     * @target注解:主要匹配正在执行的方法所在对象的类有没有指定的注解
     * @within:主要匹配正在执行的方法所声明的类上有没有指定的注解 此案例中, proxy-target-class=true以及注解不能被继承的情况下进行演示:
     * 1.用@target注解时,不会匹配到,无织入发生
     * 2.用@with注解时,insert方法有织入发生,update无织入发生
     */
    private static void testWithinAndTargetAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AbsEmployeeServiceImpl employeeService = context.getBean("emp", AbsEmployeeServiceImpl.class);
        employeeService.getAll();
        employeeService.update();
        employeeService.insert();
    }


    /**
     * 这个代码演示了注解修饰在EmployeeService接口上的方法是不生效的,不会有织入发生
     * 这个主要跟java注解的技术有关
     */
    private static void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = context.getBean("emp", EmployeeService.class);
        employeeService.getAll();
        employeeService.getById();
        employeeService.deleteById();



    }

    private static void testMultiImpl() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceImpl employeeService = context.getBean("emp", EmployeeServiceImpl.class);
        employeeService.getAll();
        employeeService.getById();
        employeeService.deleteById();
        employeeService.xxx();

        EmployeeServiceImpl2 employeeService2 = context.getBean("emp2", EmployeeServiceImpl2.class);
        employeeService2.getAll();
        employeeService2.getById();
        employeeService2.deleteById();
        employeeService2.yyy();
    }
}
