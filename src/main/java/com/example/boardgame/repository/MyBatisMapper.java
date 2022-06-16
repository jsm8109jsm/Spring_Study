package com.example.boardgame.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;

/* /repository/MyBatisMapper.interface */
@Mapper
public interface MyBatisMapper {
    List<HashMap<String,Object>> findAll();
    HashMap<String,Object> findById(HashMap<String,Object> params);
}
