package com;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author cj
 * @date 2019/11/22
 */
@HandlesTypes(MyAppInitializer.class)
public class MyServletContainerInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> clazzes, ServletContext ctx) throws ServletException {
       //下面的2行代码已经注册成功一个servlet了.
       /* ServletRegistration.Dynamic servletRegistration =
               ctx.addServlet("first", new FirstServlet());

        servletRegistration.addMapping("/first");*/

        for (Class<?> clz : clazzes) {
            //就是判断传递过来的类型是否是MyAppInitializer的实现类
            //因为HandleTypes可以填多个类型
            if (MyAppInitializer.class.isAssignableFrom(clz)) {
                try {
                    MyAppInitializer instance = (MyAppInitializer) clz.newInstance();
                    instance.dangQiDongShi(ctx);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
