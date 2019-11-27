package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/16
 */
public class Main {
    public static void main(String[] args) {
        //ApplicationContext代表着spring容器,是个接口
        //spring的容器指的就是ApplicationContext这种类型的接口体系
        //ApplicationContext是一个容器类

        //容器的启动:指的就是实例化一个容器实现类的时候,
        //容器的关闭:一般是容器对象被销毁或者调用其close方法

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao dao = (EmployeeDao) context.getBean("first");
        EmployeeDao dao2 =  context.getBean("first",EmployeeDao.class);
        System.out.println("-----debug: dao = " + dao);
        System.out.println("-----debug: dao = " + dao2);
    }
}
