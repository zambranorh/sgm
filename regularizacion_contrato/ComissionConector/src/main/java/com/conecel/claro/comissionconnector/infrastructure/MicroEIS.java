package com.conecel.claro.comissionconnector.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class MicroEIS {
	
	@Value("${infra.eis.url}")
	private static String URLConnection;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void connect() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(URLConnection, String.class);
			System.out.println(result);
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
}