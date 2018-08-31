package com.conecel.claro.lotconector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import com.conecel.claro.lotconector.service.NotificationInfoService;

@SpringBootApplication(scanBasePackages = { "com.conecel.claro" })
@EntityScan("com.conecel.claro.lotconnector.dto")

public class LotConnectorApplication {

	@Autowired
	NotificationInfoService notificationInfoService;

	// REDIS
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// produccion
		//factory.setHostName("redis-service");
		// desarrollo
		factory.setHostName("172.17.0.1");//10.0.75.1
		// factory.setUsePool(true);
		return factory;
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(notificationInfoService.getConnectTimeout())
				.setReadTimeout(notificationInfoService.getReadTimeout()).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(LotConnectorApplication.class, args);
	}
}
