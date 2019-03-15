package com.github.fish56.messageboard.interceptor;

import com.github.fish56.messageboard.dao.imp.UserDaoImp;
import com.github.fish56.messageboard.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Verifier extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String auth = request.getHeader("Authorization");
        if (auth == null){
            return true;
        }
        // "bearer sfasf"  --> ["bearer", "sfasf"]
        String a[] = auth.split("\\s+");
        if (a.length == 2){
            String token = a[1];
            User user = UserDaoImp.getInstance().selectOneByToken(token);
            if(user != null){
                request.setAttribute("VerifiedUsername",user);
            }
        }
        return true;
    }
}
