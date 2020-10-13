package com.navy.hangmu002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.navy.jianzaiji.service"})
public class Hangmu002Application {

	public static void main(String[] args) {
		SpringApplication.run(Hangmu002Application.class, args);
	}

}
