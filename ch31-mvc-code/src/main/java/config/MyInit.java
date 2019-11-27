package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author cj
 * @date 2019/11/22
 */
public class MyInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(MvcConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

      ServletRegistration.Dynamic servletRegistration=
              servletContext.addServlet("asdf", dispatcherServlet);
        servletRegistration.addMapping("/");

    }
}
