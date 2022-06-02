package com.example.boardgame.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.example.boardgame.entity.User;
import com.example.boardgame.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RequiredArgsConstructor 어노테이션을 사용한 "생성자 주입"
@RequiredArgsConstructor
//@Controller는 주로 View를 반환하기 위해 사용
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/select")
    @ResponseBody
    public Map<String, Object> selectAllUser(){
        System.out.println("aa1");
        Map<String, Object> response = new HashMap<>();
        System.out.println("aa2");
        List<User> userList = userService.selectAll();
        System.out.println("aa3");
        System.out.println(userList);
        response.put("result", userList);

        return response;
    }
}
