package config.complex;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author cj
 * @date 2019/11/6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MybatisSpringConfiguration.class)
public @interface EnableMybatisSpring {

}
