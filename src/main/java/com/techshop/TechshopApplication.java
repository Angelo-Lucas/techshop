package com.techshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TechshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechshopApplication.class, args);
	}

}
