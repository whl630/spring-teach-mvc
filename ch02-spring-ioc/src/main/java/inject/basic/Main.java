package inject.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_basic.xml");

        DbConfig config = context.getBean("dbConfig", DbConfig.class);
        UserInfo userInfo = context.getBean("userInfo", UserInfo.class);
        System.out.println("-----debug: config = " + config);
        System.out.println("-----debug: userInfo = " + userInfo);
    }
}
