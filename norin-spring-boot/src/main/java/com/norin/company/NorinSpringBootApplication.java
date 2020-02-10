package com.norin.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.norin"})
public class NorinSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorinSpringBootApplication.class, args);
	}

}
