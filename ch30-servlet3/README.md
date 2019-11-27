# servlet动态注册方法一
1.写一个类实现ServletContainerInitializer接口
2.在此实现类中写上注册的代码
```java
public class MyServletContainerInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
       ServletRegistration.Dynamic servletRegistration =
               ctx.addServlet("first", new FirstServlet());

        servletRegistration.addMapping("/first");
    }
}
```
3.在类路径下(maven项目就是在resources下)建立/META-INF/services文件夹,
然后在此文件夹下建立一个文件,名字"必须"是javax.servlet.ServletContainerInitializer
(是ServletContainerInitializer接口的全称)
4.在此文件中,填上第一步写的类的全称,如果有多个类实现了ServletContainerInitializer
接口,就一行一个

# 动态注册servlet的第二种方法
本质上与第一种方法是类似
1.写一个类实现ServletContainerInitializer接口
2.写一个接口(一般是接口),比如叫MyAppInitializer
3.在ServletContainerInitializer实现类上添加
@HandleTypes注解,指定第二步的接口类型
用来告诉ServletContainerInitializer接口实现类的onStartup
方法的第一个参数的值
4.ServletContainerInitializer接口实现类的写法一般就是
直接调用第二步接口所有实现类的某个方法


# 作业
1. 不加HandleTypes的时候,onStartup方法第一个参数是什么?
2. 尝试用现在所学的内容注册DispatcherServlet,并让spring mvc框架生效
# 参考资料
https://www.ibm.com/developerworks/cn/java/j-lo-servlet30/index.html