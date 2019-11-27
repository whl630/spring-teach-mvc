package com;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author cj
 * @date 2019/11/22
 */
public class MyAppInitializerImpl implements MyAppInitializer {
    @Override
    public void dangQiDongShi(ServletContext sc) {
     ServletRegistration.Dynamic servletRegistration =
             sc.addServlet("xxx", new SecondServlet());
        servletRegistration.addMapping("/second");
    }
}
