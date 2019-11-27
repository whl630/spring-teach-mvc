package com;

import java.lang.annotation.*;

/**
 * @author cj
 * @date 2019/10/28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
//@Inherited
public @interface MyAnno {

}
