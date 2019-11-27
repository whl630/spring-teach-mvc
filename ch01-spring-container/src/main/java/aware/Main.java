package aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_aware.xml");
        SomeBean bean = context.getBean("someBean", SomeBean.class);
        ApplicationContext context2 = bean.getContext();

        System.out.println(context == context2);

    }
}
