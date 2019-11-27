package aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author cj
 * @date 2019/10/16
 */
public class SomeBean implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ApplicationContext getContext(){
        return this.context;
    }

    public void xx(){

    }

    @Override
    public void setBeanName(String name) {

    }
}
