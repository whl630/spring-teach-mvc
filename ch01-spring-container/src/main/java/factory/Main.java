package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/16
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_factory.xml");
        //这样得到是利用工厂类创建出来的对象
        A instance =  context.getBean("factory3",A.class);
        System.out.println(instance.getClass().getName());
    }
}
