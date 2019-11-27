# 容器
1.xml:component-scan
2 Controller,Service,Repository,Componet
3.PostConstruct,PreDestroy
4.Scope

# IOC
Autowire
    注意List与Map的注入.
Resource
Inject

    多个候选的解决办法
    @Primary
    @Qulifier
# AOP
1.aspectj-autoproxy.相当于让spring理解aop相关的注解
    proxy-target-class属性的作用
2. Aspect 切面

3.通知:
    @Before
    @After
    @AfterReturning
    @AfterThrowing
    @Around
4 切点表达式
    方法是无参无返回值
  # 读取外部属性文件
  利用PropertySource注解读取外部文件到Environment
  
  使用外部文件的数据,方法有2种
  1.利用Environment.getProperty
  2.利用Value注解
    
    @Pointcut
    
 1.作业:Autowired与Resource的区别,
 
 2.添加4个注解时,默认bean的名字是什么?如何改变
 
 3.做好笔记
 
 4 @Value注解除了修饰在字段上,还可以修饰在哪里?
 
 5.Autowired注解的required属性是什么意思?
 
 6.Autowired注解可以修饰在哪里?
 
 7.怎么读取多个外部属性文件
 
 