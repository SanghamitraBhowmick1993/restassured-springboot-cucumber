package com.springboot.e2eapitests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class E2eApiTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(E2eApiTestsApplication.class, args);
	}
//	@GetMapping
//	public String hello() {
//		return "Hello world";
//	}

}
