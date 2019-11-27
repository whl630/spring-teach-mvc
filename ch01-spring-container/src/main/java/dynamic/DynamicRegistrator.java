package dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @author cj
 * @date 2019/10/16
 */
public class DynamicRegistrator implements BeanFactoryAware {
    private  BeanFactory beanFactory ;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public <T> T register(String name,Class<T> clz,Object... args){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clz);
        for (Object arg : args) {
            definitionBuilder.addConstructorArgValue(args);
        }
        BeanDefinition definition = definitionBuilder.getRawBeanDefinition();
        ((BeanDefinitionRegistry)beanFactory).registerBeanDefinition(name, definition);
        return beanFactory.getBean(name, clz);
    }
}
