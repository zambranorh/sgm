package com.conecel.claro.loginconector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
@EntityScan("com.conecel.claro.loginconnector.domain")
public class LoginConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginConnectorApplication.class, args);
	}
}
