package com.conecel.claro.comission.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.comission.dto.ComissionInputs;
import com.conecel.claro.comission.dto.ComissionPeriod;
import com.conecel.claro.comission.service.ComissionService;
import com.conecel.claro.comission.util.ComissionResponse;
import com.conecel.claro.comission.util.GeneratedComissionResponse;

@RestController
public class ComissionApi {

	GeneratedComissionResponse generatedComissionResponse;
	
	ComissionResponse comissionResponse;
	
	@Autowired
	ComissionService comissionService;
	
	@RequestMapping(value = "/ComissionCreate", method = RequestMethod.POST)
	public GeneratedComissionResponse generateComission(@RequestBody ComissionPeriod comissionPeriod) {

		generatedComissionResponse = comissionService.generaComision(comissionPeriod);
		
		
		return generatedComissionResponse;

	}
	
	@RequestMapping(value = "/ComissionInfo", method = RequestMethod.POST)
	public ComissionResponse getComission(@RequestBody ComissionInputs comissionInputs) {

		comissionResponse = comissionService.getComissions(comissionInputs);
		
		
		return comissionResponse;

	}
}
