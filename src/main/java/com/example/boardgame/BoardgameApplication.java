package com.example.boardgame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = BoardgameApplication.class)
@SpringBootApplication
public class BoardgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardgameApplication.class, args);
	}

}
