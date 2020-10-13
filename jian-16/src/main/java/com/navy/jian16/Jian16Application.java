package com.navy.jian16;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.navy.jian16.repository")
public class Jian16Application {

	public static void main(String[] args) {
		SpringApplication.run(Jian16Application.class, args);
	}

}
