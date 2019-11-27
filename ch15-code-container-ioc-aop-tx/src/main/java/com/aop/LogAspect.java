package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @date 2019/11/4
 */

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointcut(){

    }

    @Before("myPointcut()")
    public void before(){
        System.out.println("before****");
    }

    public void after(){
        System.out.println("after----");
    }

    public void afterReturn(int ret){
        System.out.println("after return..." + ret);
    }

    public void afterThrow(RuntimeException re){
        System.out.println("after throw----" + re);
    }


    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("before in around---");
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

}
