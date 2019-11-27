package com.config;

import config.complex.MybatisSpringConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @date 2019/11/6
 */
@Component
public class CustomMybatisSpringConfigurer implements MybatisSpringConfigurer {
    @Override
    public String getMapperLocation() {
        return "classpath*:com/dao/mappers/**/*.xml";
    }
}
