package com;

import com.service.impl.DeptServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/29
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptServiceImpl deptService = context.getBean("deptService", DeptServiceImpl.class);
        try {
            deptService.deleteWholeDeptById(22);
        } catch (Throwable throwable) {
            System.out.println("-----debug: throwable.getClass().getName() = " + throwable.getClass().getName());
        }
    }
}
