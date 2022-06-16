package com.example.boardgame.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.boardgame.entity.User;
import com.example.boardgame.service.MyBatisService;
import com.example.boardgame.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {
    //    @Autowired
//    private final UserService userService;
    @Autowired
    MyBatisService myBatisService;

    @GetMapping(value = "/select")
    @ResponseBody
    public Map<String, Object> selectAllUser(){
        Map<String, Object> response = new HashMap<>();
//        List<User> userList = userService.selectAll();
//        System.out.println(userList)
//        response.put("result", userList);

        response.put("result", myBatisService.findAll());


        return response;
    }
}