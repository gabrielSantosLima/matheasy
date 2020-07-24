package com.principal.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MatheasyApplication {
	public static void main(String[] args) {
		SpringApplication.run(MatheasyApplication.class, args);
	}
}
