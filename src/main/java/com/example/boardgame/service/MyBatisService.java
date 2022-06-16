package com.example.boardgame.service;

import com.example.boardgame.repository.MyBatisMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MyBatisService implements MyBatisInterfaceService{
    @Autowired
    MyBatisMapper myBatisMapper;

    public List<HashMap<String,Object>> findAll(){
        return myBatisMapper.findAll();
    }


}
