package com.conecel.claro.rejectionconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
@EntityScan("com.conecel.claro.rejectionconnector.dto")
public class RejectionConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RejectionConnectorApplication.class, args);
	}
}
