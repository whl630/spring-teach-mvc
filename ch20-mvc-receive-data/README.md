接收数据方法有
1.直接在请求方法上添加参数
    1.1 基本数据类型
    1.2 包装类型
    1.3 复杂类型
    1.4 array,list,map,set
2 利用RequestParam进行设置,可以
    1.不必让方法参数名与请求数据名一致
    2.可以设置是否必填(required)    
    3.默认值
3 利用PathVariable,就是从url路径上取得数据
/a/b{abc} ->  abc->给方法的参数
4.RequestMapping注解修饰的方法支持的参数类型有:

5.DataBinder

6.类型转换
6.1 Converter,Formatter以及支持注解的Formatter(见AnnotationFormatterFactory接口)
6.2 ConversionService:方便使用转换,因为有各种各样的转换机制(converter,formatter,注解),
    conversionService内部把所有这些转换服务全部转变成converter,便于使用.
6.3 全局设置
    6.3.1 利用ControllerAdvice进行全局设置
    6.3.2 利用xml元数据进行设置:mvc:annotation-driven
      和FormattingConversionServiceFactoryBean
    6.3.3 FormattingConversionServiceFactoryBean注册了DefaultFormattingConversionService,
    此conversionService默认注册了数字与日期相关的2个注解相关格式化器 

6.4 Spring自带的日期处理方式有2种方式
第一种方式:
    a) 在spring的元数据xml文件中,添加mvc:annotation-driven(会添加ConversionService,里面拥有默认的converter与Formatter)
    b) 在相关的处理方法参数上加上@DateTimeFormat注解,并设置pattern
第二种方式:
    a) 在处理方法参数上"不"加DateTimeFormat注解
    b) 直接利用在xml中配置或是InitBinder注解添加日期格式化器DateFormatter
    c) 这种方式不需要在xml中添加mvc:annotation-driven
    
    注意:如果既添加了DateFormatter也加了@DateTimeFormat注解,以添加的DateFormatter为准
    (因为本质上是靠DateFormatter来进行类型转换的,DateTimeFormat注解只是用来设定转换格式方面的信息
    详情如下:利用InitBinder注解注册formatter时是注册了一个PropertyEditor的Adapter,见SimpleTypeConverter->
    TypeConverterDelegate.convertIfNecessary()方法
    ).

作业:
1.案例中演示PathVariable注解的地方,把此注解删掉
可以获取数据吗?
2.尝试做一个增加操作,要求插入到数据库,
自己尝试ssm(Spring Spring mvc,Mybatis)

做法:不需要加监听器
把以前的xml的整合方式,原封不动,拷贝到applicationContext里面

注意点:事务,mapper scan和component-scan尽量区分


# 参考资料
https://www.baeldung.com/spring-type-conversions
https://segmentfault.com/a/1190000008938863





    