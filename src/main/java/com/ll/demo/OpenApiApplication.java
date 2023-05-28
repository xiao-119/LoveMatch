package com.ll.demo;

import com.ll.demo.storage.StorageProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan("com.ll.demo.mapper")
@EnableFeignClients(basePackages = "com.ll.demo.service.client")
@EnableConfigurationProperties(StorageProperties.class)
public class OpenApiApplication {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM退出")));

		SpringApplication.run(OpenApiApplication.class, args);
	}

}
