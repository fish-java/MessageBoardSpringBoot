package com.github.fish56.messageboard.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORS extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception{
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Allow-Headers","*");
        return true;
    }
}
