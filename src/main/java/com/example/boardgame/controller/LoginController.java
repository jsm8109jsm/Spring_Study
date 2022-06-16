
package com.example.boardgame.controller;

import com.example.boardgame.entity.User;
import com.example.boardgame.service.LoginService;
import com.example.boardgame.service.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    @ResponseBody
    public String loginId(@ModelAttribute User user, HttpServletRequest request) {
        if(loginService.login(user)){
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_USER,user);
            System.out.println("세션추가");

            return "Ok";
        }else{
            return "Fail";
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public Map loginId(HttpServletRequest request) {
        Map result = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            result.put("code",200);
            result.put("msg","정상적으로 로그아웃 되었습니다.");
        }
        else{
            result.put("code",400);
            result.put("msg","세션이 없습니다.");
        }

        return result;
    }
}

