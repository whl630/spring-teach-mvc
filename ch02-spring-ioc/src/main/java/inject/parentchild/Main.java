package inject.parentchild;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @date 2019/10/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_parentchild.xml");

        //MyParent myParent = context.getBean("myParent", MyParent.class);
       // ChildOne childOne = context.getBean("childOne", ChildOne.class);
       // System.out.println("-----debug: myParent = " + myParent);
        // System.out.println(childOne);
    }
}
