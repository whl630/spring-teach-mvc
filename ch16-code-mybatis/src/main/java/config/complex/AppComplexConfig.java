package config.complex;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author cj
 * @date 2019/11/6
 */

@Configuration
@ComponentScan({"com.service","com.aspect","com.config"})//扫描业务类
@EnableAspectJAutoProxy
@EnableMybatisSpring

public class AppComplexConfig {

}
