import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import process.A;

public class text {
    @Test
    public void  get(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_process.xml");
        A a = context.getBean("A",A.class);
    }
}
