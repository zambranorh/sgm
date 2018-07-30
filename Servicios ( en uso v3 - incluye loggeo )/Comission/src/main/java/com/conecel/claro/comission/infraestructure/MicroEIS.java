
package com.conecel.claro.comission.infraestructure;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.JsonPath;



public class MicroEIS {
	

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	public MicroEIS(RestTemplate restTemplate) {
	}

	public String obtieneComision(String urlMEis, String requestId, String accountId, String informationService,
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
			
			/*EisRequest eisRequest = new EisRequest();
			
 			eisRequest.setInformationService(informationService);
 			eisRequest.setSource(dataSource);
			List<Inputs> inputs = Stream.of(new Inputs("solicitud",requestId+""),new Inputs("cuenta",accountId+"")).collect(Collectors.toList());
			
			
			eisRequest.setInputs(inputs);
			
			
			ResponseEntity<String> responseEntity = restTemplate.postForEntity(urlMEis, eisRequest , String.class);
			
			 
			
			 MediaType contentType = responseEntity.getHeaders().getContentType();
			 HttpStatus statusCode = responseEntity.getStatusCode();
			 
 		
				
			
			String json = responseEntity.getBody(); */
			
			String json = "{\"code\": 0,"
					+ "\"status\": \"OK\","
					+ "\"message\": \"Successful Response\","
					+ "\"response\": ["
					+ "{ \"amount\": 100 }"
					+ "]"
					+ "}";
			
			String exp = "$.response[*].amount";
			
 
			//https://github.com/json-path/JsonPath
			
			
			List<Integer> amounts = JsonPath.read(json, exp);
			System.out.println("Cantidad: " + amounts.size());
			if(!amounts.isEmpty()) {
				amount = ""+amounts.get(0);
				System.out.println("valor: " + amount);
			}
			
			

		} catch(Exception e) {
			log.error("Error: ",e);
			amount = null;			
		}
		return amount;
	}

 
}
