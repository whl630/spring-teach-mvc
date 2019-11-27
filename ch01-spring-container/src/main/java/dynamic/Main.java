package dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_dynamic.xml");
        DynamicRegistrator registrator = context.getBean("registrator", DynamicRegistrator.class);
        B b = registrator.register("b", B.class);
        System.out.println("-----debug: b = " + b);
        B b2 = context.getBean("b", B.class);
        System.out.println("-----debug: b2 = " + b2);
        System.out.println(b==b2);
    }
}
