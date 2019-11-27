# 上传
## 页面:
1.post提交
2.enctype:multipart/form-data

## 服务端
方法一:
1.添加apache commons依赖
2.配置commons解析器CommonsMultipartResolver ,
id的值必须配置并且必须是multipartResolver
3.控制器方法参数类型是MultipartFile,参数名是页面中文件
控件的名字(不匹配时,可以用RequestParam注解,注解的值等于控件名即可)
> 为什么必须是multipartResolver这个名字,
> 可以在DispatcherServlet的initMultipartResolver方法中看到原因,因为它固定是
> 以这个名字来找MultipartResolver类型的bean的

方法二:(推荐的方法.这种方法是利用servlet 3.0的方式,所以你的tomcat必须支持servlet 3.0)
1.配置DispatcherServlet的文件上传部分
2.配置解析器类型为StandardServletMultipartResolver,
id的值必须配置并且必须是multipartResolver(这个配置是可选的,可以不用配置)
3. 不需要添加commons的依赖

> 可以不用配置StandardServletMultipartResolver的原因是RequestParamMethodArgumentResolver
> 解析参数时,会委托给MultipartResolutionDelegate类的resolveMultipartArgument的方法去解析

# 中文乱码
1. tomcat层面设置utf-8
2. 配置全局的编码过滤器
3. 下载文件的时候文件名进行url编码
# 参考文档:
https://www.baeldung.com/spring-file-upload


# 详细说明
 spring mvc中进行文件上传处理有两种做法
 1. 利用第三方的库来处理文件上传,这个库主要的作用就是解析http协议中
 文件数据与表单数据,就是multipart/form-data编码类型提交过来的数据

 这个库一般用apache commons-fileupload

 做法的第一步:
 1.添加apache commons-flieupload依赖
 2.告诉mvc,我现在准备用这个库来做文件上传
  bean id="multipartResolver" class="org.springframework
  .web.multipart.commons.CommonsMultipartResolver

  id值必须是multipartResolver.

 3.处理文件上传的方法类型必须是MultipartFile,参数名必须跟页面
 中file控件的名字一样,如果不一样就利用@RequestParam注解取别名

 4.利用MultipartFile对象的transferTo方法保存文件即可


 第二种上传方式,就是曾经跟你们讲过的,他利用了Servlet 3.0的新技术来处理文件
 上传

 1. 在我们的DispatcherServlet上进行multipart-config的设置(在web.xml中)

 2.告诉mvc,你要用servletb标准的上传技术,也就是一个MultipartResolver解析器 *

 bean id="multipartResolver" class="org.springframework
 .web.multipart.support.StandardServletMultipartResolver

 id必须是multipartResolver


 上传过程中的中文的处理
 为什么中文会是一个问题,原因有以下几个方面产生
 1.tomcat容器本身默认的编码是ISO-8859-1
 2.页面不是utf-8
 3.浏览器传递的数据编码不是utf-8

 解决中文文件名上传的问题
 1.需要在jsp里面设置相关的utf-8
 2.配置一个过滤器来处理请求的编码问题