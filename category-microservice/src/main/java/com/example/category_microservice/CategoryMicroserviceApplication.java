package com.example.category_microservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CategoryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return  new ModelMapper();
	}

}
