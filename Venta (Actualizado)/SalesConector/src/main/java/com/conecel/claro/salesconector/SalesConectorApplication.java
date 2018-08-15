package com.conecel.claro.salesconector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
@EntityScan("com.conecel.claro.salesconnector.domain")
public class SalesConectorApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SalesConectorApplication.class, args);
	}
}
