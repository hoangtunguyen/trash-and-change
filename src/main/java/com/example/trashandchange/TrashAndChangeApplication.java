package com.example.trashandchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan( basePackages = {"com.example.trashandchange.model"} )
@EnableJpaRepositories(basePackages = {"com.example.trashandchange.repository"})
public class TrashAndChangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrashAndChangeApplication.class, args);
	}

}
