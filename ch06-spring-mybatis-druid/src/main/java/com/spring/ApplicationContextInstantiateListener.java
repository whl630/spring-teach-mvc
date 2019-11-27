package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 此监听器用来创建spring容器对象
 *
 * 因为这个监听器是servletContext监听器,在容器启动时会被调用
 * 并且只会调用一次
 * @author cj
 * @date 2019/10/22
 */
public class ApplicationContextInstantiateListener implements ServletContextListener {
    public static final String SPRING_CONTAINER_KEY = "SPRING_CONTAINER";
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String configFille = servletContext.getInitParameter("configFile");
        ApplicationContext context = new ClassPathXmlApplicationContext(configFille);

        servletContext.setAttribute(SPRING_CONTAINER_KEY,context);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
