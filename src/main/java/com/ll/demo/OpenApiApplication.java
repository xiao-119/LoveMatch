package com.ll.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan("com.ll.demo.mapper")
public class OpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiApplication.class, args);
	}

}
