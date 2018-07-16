
package com.conecel.claro.comissionconector.infraestructure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.JsonPath;



public class MicroEIS {
	

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private RestTemplate restTemplate;
	
	public MicroEIS(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}

	public String obtieneComision(String urlMEis, Long requestId, Long accountId, String informationService,
			String dataSource) {
		
		String amount = null;
		try {
			
			
 			
			/*String request = 
					"{"
					+ "\"source\":"+source+","
					+ "\"informationService\":"+comission+","
					+ "\"inputs\":["
					+ "             {"
					+ "               \"key\":\"solicitud\",\"value\":"+solicitud+""
					+ "             },"
					+ "             {"
					+ "                \"key\":\"cuenta\",\"value\":"+cuenta+""
					+ "             }"
					+ "           ]"
					+ "}";
			*/
			 

			//http://pojo.sodhanalibrary.com/
			
			EisRequest eisRequest = new EisRequest();
			
 			eisRequest.setInformationService(informationService);
 			eisRequest.setSource(dataSource);
			List<Inputs> inputs = Stream.of(new Inputs("solicitud",requestId+""),new Inputs("cuenta",accountId+"")).collect(Collectors.toList());
			
			
			eisRequest.setInputs(inputs);
			
			
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(urlMEis, eisRequest , String.class);
			
			 
			
			 MediaType contentType = responseEntity.getHeaders().getContentType();
			 HttpStatus statusCode = responseEntity.getStatusCode();
			 
 		
				
			
			String json = responseEntity.getBody();
			
			String exp = "$.response[*].amount";
			
 
			//https://github.com/json-path/JsonPath
			
			
			List<String> amounts = JsonPath.read(json, exp);
			if(!amounts.isEmpty()) {
				amount = amounts.get(0);
			}
			
			

		} catch(Exception e) {
			log.error("Error: ",e);
			amount = null;			
		}
		return amount;
	}

 
}
