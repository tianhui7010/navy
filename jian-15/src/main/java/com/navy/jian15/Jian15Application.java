package com.navy.jian15;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.navy.jian15.repository")
public class Jian15Application {

	public static void main(String[] args) {
		SpringApplication.run(Jian15Application.class, args);
	}

}
