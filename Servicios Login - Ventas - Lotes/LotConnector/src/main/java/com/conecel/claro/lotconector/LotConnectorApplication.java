package com.conecel.claro.lotconector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
@EntityScan("com.conecel.claro.lotconnector.domain")
public class LotConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotConnectorApplication.class, args);
	}
}
