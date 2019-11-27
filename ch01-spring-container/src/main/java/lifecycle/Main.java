package lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_lifeCycle.xml");

       // EmployeeDaoLifeCycle dao = context.getBean("daoLife3", EmployeeDaoLifeCycle.class);
        EmployeeDaoLifeCycle2 dao2 = context.getBean("daoLife2", EmployeeDaoLifeCycle2.class);


        //EmployeeDaoLifeCycle2 dao3 = context.getBean("daoLife2", EmployeeDaoLifeCycle2.class);


        ((ConfigurableApplicationContext)context).close();

    }
}
