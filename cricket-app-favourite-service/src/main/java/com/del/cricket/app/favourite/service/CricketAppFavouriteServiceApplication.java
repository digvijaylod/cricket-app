package com.del.cricket.app.favourite.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.del.cricket.app.favourite.service")
public class CricketAppFavouriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketAppFavouriteServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


}
