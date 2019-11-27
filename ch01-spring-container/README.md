1. HelloWorld
    maven依赖
    xml配置文件
    ApplicationContext的创建
    getBean的2种用法
    
2  工厂
    工厂类的静态方法
    工厂类的实例方法
    FactoryBean
3 作用域
    prototype
    singleton
    request
    session
    作用域的设置
    对象的创建时机
4 延迟初始化
    bean:lazy-init
    beans:default-lazy-init
5  对象的初始化方法与销毁方法
    bean
    beans
    InitializingBean,DisposableBean

6  aware接口
    ApplicationContextAware
    BeanNameAware
    
作业:
1.百度找出BeanFactory与ApplicationContext的不同
这两个类是spring框架中2个代表性的容器类型(接口)
功能上BeanFactory主要有获取实例的功能(getBean)

ApplicationContext在BeanFactory基础上进行了功能的增强
,比如,读取消息(做国际化),发布事件,重新加载资源
2.spring-core,spring-beans,spring-web各个
依赖里面大致有哪些功能?
spring-core:提供spring框架的一些核心的基础功能,比如动态代理的
创建,读取文件等

spring-beans:提供spring框架的核心的bean管理,ioc,aop等能力

spring-web::spring框架与servlet技术整合使用

3.把案例中AFactory类的createB
方法的代码改为return new A();
请问这种方式A的作用域是单例还是原型
答:是否单例与bean配置的scope有关.如果prototype,那么就是原型

4.配置bean的时候,其lazy-init是什么意思?
lazy-init:延迟初始化的意思
spring容器启动时,默认是马上实例化scope为singleton对象
这种做法有一个缺点,就是如果spring容器管理的bean过大,就会导致
性能低,所以就提供了一个选项lazy-init,设置为true的时候
容器启动的时候,这个设置的bean不会立即实例化,而会等到第一次
调用getBean获取实例对象是才实例化.

这个lazy-init属性对scope为prototype的bean无效.


5.理解prototype作用域时,为什么销毁方法不生效?

因为prototye就是每次getBean的时候临时创建一个新的对象
,此对象不会被spring所引用,所以就无法对其生命周期进行管理,
所以就不会有销毁方法被调用

singleton的bean,由于在容器启动时会创建对象出来,而且
会被spring所引用,管理,所以当spring关闭时,会调用其销毁方法

自学内容(可选):
    学习案例中dynamic包下相关内容
  目标:
  1.能理解BeanDefinition
  2.能理解BeanDefinitionBuilder
  3.能了解BeanDefinitionRegistry
  4.理解动态注解的作用与使用场景 

