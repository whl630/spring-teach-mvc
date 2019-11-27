package com.cj.mybatis.spring.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SimpleMapperScannerRegistrar.class)
public @interface MapperScan{
    String[] value() default {};

}
