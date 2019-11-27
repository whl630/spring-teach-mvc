package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author cj
 * @date 2019/11/6
 */
@Component
@Aspect
@Order(50)// 调成一个比较小的数字意味着优先级更高
public class PerformanceAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointcut(){

    }
    @Around("myPointcut()")
    public Object performance(ProceedingJoinPoint joinPoint){
        Object result = null;

        try {
            Long start = System.currentTimeMillis();
            result = joinPoint.proceed();
            Long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end -start));
        } catch (Throwable throwable) {
            System.out.println("-----debug: throwable.getClass().getName() = " + throwable.getClass().getName());
            //必须抛出异常,否则事务不生效,因为捕获了异常,spring的事务处理器认为没有错误,就直接提交不回滚
            //spring对持久层的处理的顶级异常是DataAccessException,然后mybatis会把自己的异常翻译为spring的异常
           /* if (throwable instanceof DataAccessException) {
                throw (DataAccessException)throwable;
            }
            */
        }
        return result;
    }
}
