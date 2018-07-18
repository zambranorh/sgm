package com.conecel.claro.salesconector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
public class SalesConectorApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SalesConectorApplication.class, args);
	}
}
