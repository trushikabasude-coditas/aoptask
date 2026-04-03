package com.example.AOPTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopTaskApplication.class, args);
	}

}
