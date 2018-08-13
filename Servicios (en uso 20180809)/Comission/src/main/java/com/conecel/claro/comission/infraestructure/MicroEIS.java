
package com.conecel.claro.comission.infraestructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.JsonPath;



public class MicroEIS {
	

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	RestTemplate restTemplate;
	
	public MicroEIS(RestTemplate restTemplate) {
		
		this.restTemplate = restTemplate;
	}

	public String obtieneComision(String urlMEis, String requestId, String accountId, String informationService,
			String dataSource) {
		
	String amounts="0";
	
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
			
			String request = "{" + 
					"	\"dsId\":\""+  dataSource  +"\"," + 
					"	\"pnIdServicioInformacion\":\""+informationService+"\"," + 
					"     \"sentencias_binds\": [{\"parametros\": [" + 
					"     {\"parameterValue\": \""+requestId+"\"}," + 
					"     {\"parameterValue\": \""+accountId+"\"}" + 
					"     ]}]" + 
					"}";
			 

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
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Content-Type", "application/json");

			HttpEntity <String> httpEntity = new HttpEntity <String> (request, httpHeaders);
	
			
			String json = restTemplate.postForObject(urlMEis, httpEntity, String.class);
			
			System.out.println("Json: " + json);
		
			String exp = "$.pvresultadoOut.datos.registro.valor";
			
			
			
			
			//amounts = JsonPath.read(json, exp);
			amounts=amounts+"";
			
			
			if ("".equals(amounts.trim())) {
				amounts="0";
			}
			
			
		/*String json = "{\"code\": 0,"
					+ "\"status\": \"OK\","
					+ "\"message\": \"Successful Response\","
					+ "\"response\": ["
					+ "{ \"amount\": 100 }"
					+ "]"
					+ "}";
			
			String exp = "$.response[*].amount";*/
			
 
			//https://github.com/json-path/JsonPath
			
			
			/*List<Integer> amounts = JsonPath.read(json, exp);
			System.out.println("Cantidad: " + amounts.size());
			if(!amounts.isEmpty()) {
				amount = ""+amounts.get(0);
				System.out.println("valor: " + amount);
			} */
			
			

		} catch(Exception e) {
			log.error("Error: ",e);
			return  "0";			
		}
		return amounts;
	}

 
}
