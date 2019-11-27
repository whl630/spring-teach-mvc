# 全局异常处理
控制器方法抛出异常,会被标识了@ControllerAdvice注解的类中的标记了@ExceptionHandler方法
去处理.
## ControllerAdvice注解
此注解修饰的类一般只写3种类型的方法
1 @InitBinder
2 @ModelAttribute
3 @ExceptionHandler

此注解的属性主要用来限制此类可以作用在哪些控制器上.

## ExceptionHandler
下面的代码表明此异常处理方法可以处理算术异常及其子异常
```java
 @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ae){
        return "error";
    }
```

异常处理方法的参数一般就是某个异常类型,可以写Throwable这个顶级异常

异常处理可以返回的类型与RequestMapping注解修饰的方法的返回类型一致.

> 注意:异常处理方法不能处理视图找不到的情况,因为它主要作用在控制器方法执行过程中

# RestControllerAdvice
等价于ControllerAdvice + ResponseBody注解


# 异常执行源码分析
初始化时
1. 在DispatcherServlet中的initStrategies方法中调用initHandlerExceptionResolvers方法
2. initHandlerExceptionResolvers方法会找是否在spring中有注册异常处理处理器,没有就用默认的
3. 默认的异常处理器在DispatcherServlet.properties文件中可以看到,其中的ExceptionHandlerExceptionResolver
    就是用来处理@ExceptionHandler注解的
4. ExceptionHandlerExceptionResolver类的afterPropertiesSet方法会调用initExceptionHandlerAdviceCache方法
5. initExceptionHandlerAdviceCache方法会在spring容器中找到所有修饰了
    ControllerAdvice(直接或间接,比如@RestControllerAdvice)注解的bean
6. 实例化ExceptionHandlerMethodResolver类,实例化时会找出所有的异常处理方法(修饰了@ExceptionHandler注解的方法)

执行时:
1. 调用DispatcherServlet的doDispatch,此方法调用processDispatchResult
2. processDispatchResult方法会调用processHandlerException方法
3. processHandlerException方法遍历所有的异常解析器的resolveException方法不返回空就结束遍历
4. 会调用ExceptionHandlerExceptionResolver类的doResolveHandlerMethodException方法
5. doResolveHandlerMethodException会调用getExceptionHandlerMethod,会依据当前抛出的异常,找到合适的
异常处理方法来处理异常
6. resolveException方法也返回ModelAndView类型
7. 回到processDispatchResult方法,看是否有视图,右视图就调用render方法呈现视图,
没有就直接响应(比如@ResetControllerAdvice修饰的情况)

> 异常处理是一个理解控制器方法执行逻辑的好地方,相对简单,对理解参数解析器与结果解析器非常好入手.


# ControllerAdvice执行源码分析
1. @ControllerAdvice注解修饰的bean在运行时是靠ControllerAdviceBean记录信息的
2. ControllerAdviceBean主要用在ExceptionHandlerExceptionResolver与RequestMappingHandlerAdapter中
3. 用在异常中的流程上面已经分析过了.用在RequestMappingHandlerAdapter的主要作用是找到InitBinder与ModelAttribute
两个注解修饰的方法,见initControllerAdviceCache方法
4. InitBinder修饰的方法在会在创建DataBinderFactory对象时使用.ModelAttribute的类似

