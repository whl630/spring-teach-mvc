# 校验的基本理论
1. 校验分为前端校验和后端校验
前端校验:js完成,主要的目的是用户友好,但是
最大的问题是js可以被禁用.
搜索:jquery 非侵入式校验(jquery unobtrusive)


后端校验:是必须要有.

# spring 中的校验大体可以分为2套
一套是spring自己实现的校验体系
另外一套是java标准校验(学的是这一个)


# spring校验做法步骤如下:
1. 添加依赖
2.给实体类加校验用的注解
3.给控制器方法需要校验的每一个参数都要加@Valid注解,表示需要校验
4. 在xml中要配置mvc:annotation-driven,表示启用spring mvc校验功能
5.给每一个需要校验的参数后面,加一个BindingResult类型

RequestMapping("/insert")
xxx(@Valid SomeEntity e1,BindingResult br,
@Valid SomeEntity2 e2,BindingResult br2)


# 校验错误分类2大类:
1.字段级别的错误,比如usernmae长度在2-8之间
2.类级别的错误,比如一个类中有2个字段,分别叫出生日期与雇佣日期
这2个字段进行比较,就叫做类级别

# 自定义校验注解
1. 写一个注解(可以参考jsr自带的注解)
    必须有message,payload,group
2. 注解上通过@Constraint(约束,限制的意思)指定此注解的校验器

3.写一个校验器,实现ConstraintValidator接口

4.在isValid方法里面写校验逻辑

5.把第一步编写的注解像jsr注解一样使用即可    

作业:
1 上次的整合mybatis作业中插入操作,添加校验功能
2. 用上至少5个校验注解
3. 校验失败回到填数据页面,并且有红色的信息,提示到底哪里错了
4.校验成功就真正插入到数据库

# 参考资料
https://blog.csdn.net/u013815546/article/details/77248003

# 校验相关源代码
研究方法:写一个自定义的校验器,加一个断点,就可以知道谁在调用这个方法

主要逻辑:
1. 在xml中添加mvc-annotation-driven,利用AnnotationDrivenBeanDefinitionParser
中依据是否出现javax.validation.Validator类来注册OptionalValidatorFactoryBean
(OptionalValidatorFactoryBean是SpringValidatorAdapter的子类,
SpringValidatorAdapter类实现了SmartValidator)
2. 在获取RequestMappingHandlerAdapter bean对象的时候会调用设置ConfigurableWebBindingInitializer
3. ConfigurableWebBindingInitializer初始化器会设定校验器
4. 在创建DataBinder对象的时候,初始化器会把校验器设定到DataBinder中
5. 每次请求过来时,ArgumentResolver会调用DataBinder的validate方法来处理校验
    在RequestMappingHandlerAdapter的 invokeHandlerMethod方法中开始
        1 invokeHandlerMethod调用getDataBinderFactory
        2 getDataBinderFactory调用createDataBinderFactory
        3 createDataBinderFactory调用getWebDataBinderInitializer

