package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * PropertySource注解是可以重复出现的.
 *
 * 此注解只需要放在任意一个被spring管理的bean上面
 * 就表示让spring读取外部的文件
 *
 * @author cj
 * @date 2019/11/4
 */
@Component
@PropertySource("classpath:db.properties")

public class DbConfig {
    /**
     * Environment:环境的意思
     *
     * 里面存放的是各种来源的数据,
     * 比如os的全局的环境变量
     * jvm的一些变量
     * 外部的属性文件
     */
   /* @Autowired
    private Environment environment;
*/

    /**
     * Value注解有以下几个特点:
     * 1.支持spring的el表达式
     * 2.冒号分隔表示是默认值,读取不到数据就使用冒号后的作为默认值
     */
   @Value("${jdbc.username:myroot}")
   private String username;

    public String getData(){
        return username;
       // return environment.getProperty("jdbc.username");
    }

}
