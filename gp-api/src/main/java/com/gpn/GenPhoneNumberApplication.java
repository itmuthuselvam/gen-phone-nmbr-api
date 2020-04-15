package com.gpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GenPhoneNumberApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GenPhoneNumberApplication.class, args);
	}
	
}
