package com.conecel.claro.comission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.conecel.claro.comission.service.ComissionInfoService;

@SpringBootApplication(scanBasePackages= {"com.conecel.claro"})
@EntityScan("com.conecel.claro.comission.domain")
public class ComissionApplication {
	
	@Autowired
	ComissionInfoService comissionInfoService;
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
    {
        return restTemplateBuilder
           .setConnectTimeout(comissionInfoService.getConnectTimeout())
           .setReadTimeout(comissionInfoService.getReadTimeout())
           .build();
    } 

	public static void main(String[] args) {
		SpringApplication.run(ComissionApplication.class, args);
	}
	
	
}
