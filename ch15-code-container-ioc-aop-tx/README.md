# 配置类
Configuration注解,此注解上也有Component元注解,所以配置类本身也会作为一个普通的bean注册到spring容器中

配置类由于会创建动态代理来实现bean的注册，所以要求配置类不能修饰final。

## Configuration的写法

```java

@Configuration
public class MyConfig{
  
}
```

或者

```java
@Configuration
public class MyConfig{
  
  @Configuration
  public static MyConfigInnerOne{
    
  }
  
  @Configuration
  public static MyConfigInnerTwo{
    
  }
}
```

后一种写法主要的作用是起到一个组织的作用，与顶级配置类的作用是一样的。

## Bean方法

Bean修饰的方法。

### 名字与别名

默认是方法的名字，可以通过name属性指定名字与别名，比如

```java
  @Bean({"dataSource", "A-dataSource", "B-dataSource"})
    public DataSource dataSource() {

    }
```

上面的配置表明注册的bean的名字为dataSource，别名为A-dataSource,B-dataSource



### 静态与实例bean方法

bean方法可以是实例方法也可以是静态方法,静态的bean方法一般用来注册BPP和BFPP。如果用实例bean方法来注册BPP和BFPP可能导致配置类里使用Autowired与Value注解失效。

> be particularly careful with `BeanPostProcessor` and `BeanFactoryPostProcessor` definitions through `@Bean`. Those should usually be declared as `static @Bean` methods, not triggering the instantiation of their containing configuration class. Otherwise, `@Autowired` and `@Value` do not work on the configuration class itself, since it is being created as a bean instance too early.

### 作用域

使用Scope注解实现，比如

```java
@Configuration
public class MyConfiguration {
    @Bean
    @Scope("prototype")
    public EmployeeDao dao() {
    }
}
```



### 生命周期方法

主要靠Bean注解的initMethod与destroyMethod属性来实现。在用java代码配置的情况下，默认会自动把类中的公有close方法或者shutdown方法注册为destroyMethod，如果不想使用这个特性就把destroyMethod属性设置为“”

```java
@Bean(initMethod = "init",destroyMethod="destroy")
public EmployeeDao dao() {
    return new EmployeeDaoImpl();
}
```



### full和lite 模式

bean方法出现在非Configuration修饰的类里面就称之为lite模式,bean方法甚至可以出现在非Component注解修饰的类里面
lite模式的bean方法主要特性如下:

1. 不支持内部bean依赖(inner-bean)的形式,因为它会当成普通的方法调用,而不会认为是其它bean方法调用的依赖形式
2. 由于不在Configuration类里面，所以不会创建代理类，也就不需要所属的类不能有final修饰符的要求



# AnnotationConfigApplicationContext

此类型是spring 3.0推出，支持Configuration类与Component类作为输入参数来创建spring容器，其在web环境下对应的容器类为AnnotationConfigWebApplicationContext。基本使用方法如下：

```java
//参数为配置类   
ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
```



或者

```java
//参数为组件类   
ApplicationContext ctx = new AnnotationConfigApplicationContext(MyServiceImpl.class, Dependency1.class, Dependency2.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
```



## register



```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class, OtherConfig.class);
    ctx.register(AdditionalConfig.class);
    ctx.refresh();
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
```



## scan

```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com");
    ctx.refresh();
    MyService myService = ctx.getBean(MyService.class);
```

## AnnotationConfigWebApplicationContext

```xml
 <context-param>
        <param-name>contextClass</param-name>
        <param-value>
            org.springframework.web.context.support.AnnotationConfigWebApplicationContext
        </param-value>
    </context-param>

    <!-- Configuration locations must consist of one or more comma- or space-delimited
        fully-qualified @Configuration classes. Fully-qualified packages may also be
        specified for component-scanning -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.acme.AppConfig</param-value>
    </context-param>

    <!-- Bootstrap the root application context as usual using ContextLoaderListener -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
```



# ioc



配置注入有3种方式。

## 直接调用

```java
@Configuration
public class MyConfig{
  @Bean
  public EmployeeDao employeeDao(){}
  
  @Bean
  public EmployeeService employeeService(){
    EmployeeServiceImpl service = new EmployeeServiceImpl(employeeDao());
    return service;
  }
}
```



## autowired

```java
@Configuration
public class MyConfig{
  @Autowired //背后的理论是配置类是个普通的bean，也可以注入
  private EmployeeDao dao;
  @Bean
  public EmployeeDao employeeDao(){}
  
  @Bean
  public EmployeeService employeeService(){
    EmployeeServiceImpl service = new EmployeeServiceImpl(dao);
    return service;
  }
}
```



## 直接放在bean方法的参数上

```java
@Configuration
public class MyConfig{
  @Bean
  public EmployeeDao employeeDao(){}
  //类似于构造函数注入
  @Bean
  public EmployeeService employeeService(EmployeeDao dao){
    EmployeeServiceImpl service = new EmployeeServiceImpl(dao);
    return service;
  }
}
```



三种方式并没有谁优谁劣的问题，只是要注意直接方法调用的方法必须要求被调用的bean方法是可以调用的，一般就是要求调用方与被调用方在同一个配置类中。

# AOP
EnableAspectJAutoProxy

# 事务
EnableTransactionManagement 默认事务管理器名字为txManager,transactionManager或tm就可以了，如果不是这个名字,会依据类型PlatformTransactionManager来找相关的事务管理器。(DataSourceTransactionManager是PlatformTransactionManager接口的实现类)

# 引入其它配置元数据

## Import

## ImportResource



# 作业

1.利用jdbcTemplate完成14章的案例
但是需要用代码配置方式,要求
a)有事务
b)有before通知,随便输出

推荐的步骤
1.编写配置类
2.扫描自己写的类
3.利用bean方法注册datasource与事务管理器
4.实现切面

