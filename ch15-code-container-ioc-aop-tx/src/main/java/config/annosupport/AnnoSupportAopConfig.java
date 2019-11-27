package config.annosupport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ComponentScan类似于xml中的context:componentScan
 * 要求被管理的bean有相关的的注解
 *
 * EnableAspectJAutoProxy注解等价于xml中的aop:aspectj-Auto-Proxy
 * @author cj
 * @date 2019/11/5
 */

@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
public class AnnoSupportAopConfig {

}
