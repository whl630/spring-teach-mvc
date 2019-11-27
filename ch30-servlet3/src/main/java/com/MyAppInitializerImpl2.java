package com;

import javax.servlet.ServletContext;

/**
 * @author cj
 * @date 2019/11/22
 */
public class MyAppInitializerImpl2 implements MyAppInitializer {
    @Override
    public void dangQiDongShi(ServletContext sc) {
        System.out.println("do nothing-----");
    }
}
