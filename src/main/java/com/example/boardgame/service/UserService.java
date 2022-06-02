package com.example.boardgame.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.example.boardgame.repository.userRepository;
import com.example.boardgame.entity.User;
import java.util.List;
//@Transactional은 클래스나 메서드에 붙여줄 경우, 해당 범위 내 메서드가 트랜잭션이 되도록 보장
@Transactional
//@RequiredArgsConstructor 어노테이션을 사용한 "생성자 주입"
@RequiredArgsConstructor
//@service 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션
@Service

public class UserService {
    private final userRepository userRepository;
    public List<User> selectAll() {
        return userRepository.findAll();
    }
}