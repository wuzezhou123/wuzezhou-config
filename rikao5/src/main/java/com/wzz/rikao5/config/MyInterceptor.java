package com.wzz.rikao5.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    private Logger log= LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截器"+requestURI);
        if(request.getSession().getAttribute("user")!=null){
            return true;
        }
        if(requestURI.endsWith("/index")){
            response.sendRedirect("/login");
            return false;
        }


        return true;
    }
}
