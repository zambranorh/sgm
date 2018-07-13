package com.conecel.claro.comissionconector;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("comissionconector")
public class Gateway {

	@RequestMapping(path="/charge11", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String calculate(@PathVariable("requestId") String requestId, @PathVariable("accountId") String accountId){
		return "La solicitud es -->" + requestId + ", el numero de cuenta es " + accountId;
	}
	
}
