package com.example.boardgame.intercepter;

import com.example.boardgame.service.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SessionIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Session Check - Session X
        if(request.getSession().getAttribute(SessionConst.LOGIN_USER) == null){
            // 세션이 없을 시, login으로 Redirect
            //response.sendRedirect("/login");
            System.out.println("세션없음");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }
        return true;
    }
}