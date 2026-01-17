package com.krish.app.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringDataJpaApplication.class, args);
	}

}
