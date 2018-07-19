package com.conecel.claro.salesconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.salesconector.service.IPreSalesService;

import com.conecel.claro.salesconector.util.PreSalesResponse;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

@RestController
public class PreSalesApi {
	
	PreSalesResponse preSalesResponse;
	@Autowired
	IPreSalesService preSalesService;
	
	
	
	@RequestMapping(value = "/SalesInfo", method = RequestMethod.POST)
	public PreSalesResponse getSalesDetail(@RequestBody PreSalesInfo preSalesInfo) {

		preSalesResponse = preSalesService.salesDetail(preSalesInfo);
		return preSalesResponse;

	}

}
