package com.xml;

import com.cj.mybatis.spring.xml.SimpleMapperFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author cj
 * @date 2019/10/23
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String, SimpleMapperFactory> maps = context.getBeansOfType(SimpleMapperFactory.class);
        for (Map.Entry<String, SimpleMapperFactory> entry : maps.entrySet()) {
            System.out.println("-----debug: Key() = " + entry.getKey() + "--- value: " + entry.getValue());
        }

        String beanNamesForType = context.getBeanNamesForType(SimpleMapperFactory.class)[0];
        System.out.println("-----debug: beanNamesForType = " + beanNamesForType);
        SimpleMapperFactory factory = context.getBean("a", SimpleMapperFactory.class);
        System.out.println("-----debug: factory = " + factory);
    }
}
