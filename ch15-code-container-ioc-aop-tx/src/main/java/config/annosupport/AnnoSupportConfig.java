package config.annosupport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ComponentScan类似于xml中的context:componentScan
 * 要求被管理的bean有相关的的注解
 * @author cj
 * @date 2019/11/5
 */

@Configuration
@ComponentScan("com")
public class AnnoSupportConfig {


}
