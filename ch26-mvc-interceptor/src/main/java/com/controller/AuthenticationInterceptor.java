package com.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cj
 * @date 2019/11/20
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----auth ------");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username==null ){
            response.sendRedirect("/login");
            return false;
        }
        return true;

    }
}
