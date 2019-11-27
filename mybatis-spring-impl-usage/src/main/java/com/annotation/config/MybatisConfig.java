package com.annotation.config;

import com.cj.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cj
 * @date 2019/10/24
 */

@Configuration
@MapperScan("com.dao")
public class MybatisConfig {
}
