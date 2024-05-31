package com.practice.crud_starter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudStarterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner print(String[] args) {
		
		return runner ->{
			System.out.println("Hello World!");
		};
	}
	
}
