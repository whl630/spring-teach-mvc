package config;

import com.dao.EmployeeDao;
import com.dao.impl.EmployeDaoImpl;
import com.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Configuration注解放置在类上面
 * 一般这样做:
 * 1.所有的配置类,单独用一个包存放
 * 2.此注解一般放在单独的类上面,比如下面的HelloConfig
 * 3.此注解放在某个配置类内部的静态类上面,这种配置方法跟顶级类上
 * 添加Configuration注解一样.主要起到组织作用,把相关的东西
 * 放在一起配置
 *
 *
 * 2 .Configuration上面也有一个元注解Component
 *意味着这个配置类自己本身也是一个被spring管理的普通bean
 *
 * bean方法:用Bean注解修饰的方法
 *
 * bean方法可以出现在配置类里面,也可以出现在普通类里面
 * 第一种称之为full模式,第二种情况称之为lite模式.
 *
 *
 * @author cj
 * @date 2019/11/5
 */
@Configuration
public class HelloConfig {
/*    @Autowired
    private EmployeeDao dao;*/
    /**
     * 加了Bean注解的方式,其作用是用来往spring中注册bean的
     *  没有指定Scope,默认就是单例
     *
     *  bean方法,如果放在@Configuration修饰的类中,那么此类会被动态代理
     *  也就是说bean方法已经被动态代理了.
     *  代理之后的方法的运行逻辑是这样:
     *  1.检查当前spring容器中有没有这个bean已经注册,
     *  没有就调用这个bean方法,有就直接返回,什么都不干.
     * @return
     */
    @Bean
    public EmployeDaoImpl employeDaoImpl(){
        return new EmployeDaoImpl();
    }

    @Bean()
    public EmployeeServiceImpl employeeService(EmployeeDao dao){
        EmployeeServiceImpl service =  new EmployeeServiceImpl();
        //调用employeeDaoImpl等价于context.getBean()
       // service.setDao(employeDaoImpl());
        service.setDao(dao);
        return  service;
    }


    /*@Bean
    public EmployeeServiceImpl2 employeeServiceImpl2(){
        EmployeeServiceImpl2 employeeServiceImpl2 = new EmployeeServiceImpl2();
        employeeServiceImpl2.setDao(employeDaoImpl());
        return  employeeServiceImpl2;
    }
*/

    @Configuration
    static  class MyInnerConfig {

    }
}
