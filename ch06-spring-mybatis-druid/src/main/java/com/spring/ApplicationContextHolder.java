package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author cj
 * @date 2019/10/22
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }

    public static <T> T getBean(String name,Class<T> clz){
        return context.getBean(name,clz);
    }
}
