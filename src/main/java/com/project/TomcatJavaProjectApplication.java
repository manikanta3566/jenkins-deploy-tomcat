package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomcatJavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatJavaProjectApplication.class, args);
	}

	@GetMapping("/test")
	public String test(){
		return "deployed to tomcat";
	}

}
