# 响应json数据
方法有3种
1. 类上面有@Controller注解,方法上有ResponseBody
2. 类上面有@Controller 和ResponseBody注解
3. 类上面有@ResetController注解

## 原理:
    ResponseBody注解主要是靠HttpMessageConverter来处理,处理方式是
    直接把控制器方法的返回数据,经过某一个消息转换器处理之后,发送到http协议
    的响应体里面

## 日期的处理
    方法1:直接在类上面加JsonFormat,只对这一个有效.只对jackson序列化有效
    方法2:是在applicationContext中配置消息转换器,这个是全局有效,不需要加JSONFormat注解
# 接收JSON数据
    步骤如下:
    1.请求方法参数上要加RequestBody注解
    2.客户端发起请求时,必须是post请求
    3.客户端发起请求时,传递过来的数据,必须能反序列化为被
    RequestBody修饰的参数的类型
 
 # 源码分析
 ## 初始化时
 我们以代码配置入手,xml配置方式是类似的
 1. 添加EnableWebMvc,导入了WebMvcConfigurationSupport类
 2. WebMvcConfigurationSupport提供配置消息转换器与添加默认转换器的功能,
    可以在此类的getMessageConverters的方法中看到应用
 3. 在WebMvcConfigurationSupport类中配置HandlerAdapter时会用到消息转换器,
    见方法requestMappingHandlerAdapter
 4. 在RequestMappingHandlerAdapter类的afterPropertiesSet方法中有添加返回值处理器,
    它会调用getDefaultReturnValueHandlers方法,而此方法会实例化RequestResponseBodyMethodProcessor对象
    并把消息转换器传递给RequestResponseBodyMethodProcessor对象会选择一个支持的结果处理者,并用它处理结果

    
 ## 控制器方法执行时
 1. RequestMappingHandlerAdapter类的invokeHandlerMethod方法中
 2. invokeHandlerMethod会调用ServletInvocableHandlerMethod对象的invokeAndHandle方法
 3. invokeAndHandle方法会选择一个合适的结果处理者,并用它处理结果,见HandlerMethodReturnValueHandlerComposite
    类的handleReturnValue方法 
 4. 所有的结果处理者中,只要有一个表明它可以处理结果,就直接用这一个处理者,见selectHandler方法
 5. 每一个结果处理者表明自己可以处理结果是靠supportsReturnType方法来实现的
 6. RequestResponseBodyMethodProcessor类的supportsReturnType实现是看是否有ResponseBody注解 
 7. RequestResponseBodyMethodProcessor类的handleReturnValue方法调用writeWithMessageConverters
 (注意:也在这个方法中设置了ModelAndViewContainer对象的setRequestHandled=true,表明直接处理请求,不走后续的视图解析流程)
 8. writeWithMessageConverters方法会遍历所有的消息转换器,通过调用消息转换器的方法canWrite
    确定用哪一个消息转换器
 9. 而MappingJackson2HttpMessageConverter类实现canWrite是看ObjectMapper是否可以序列化方法返回值(见此类的父类中canWrite方法实现)
 10.最后调用消息转换器的write方法,完成响应   
 # 作业:
 
 整合SSM(xml)
 完成插入与查询操作(用ajax的方式) 
 查询返回的是List集合
 插入操作传递的数据来自于表单输入

实验一个这样的情况:
1.改动jdbc url,改到不能连接到数据库,就一定会报错.

js怎么处理这种情况?
# 参考资料
https://cloud.tencent.com/developer/article/1153572(替换为GSON)
https://my.oschina.net/keywindy/blog/223052(设置jackson日期格式)
https://www.baeldung.com/spring-boot-formatting-json-dates(spring boot中设置日期)