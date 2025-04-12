package com.resturent.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.resturent.restaurant.model") // add this if your entities are in a sub-package
@EnableJpaRepositories("com.resturent.restaurant.repository")

public class RestaurantApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
        
	}
/*

@Bean
CommandLineRunner demo() {
   return args -> {
        restaurantRepositoryService.saveData();
    };
} */


}


