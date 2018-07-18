package com.conecel.claro.comissionconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.conecel.claro.comissionconector.dto.PreComissionInfo;
import com.conecel.claro.comissionconector.service.PreComissionService;
import com.conecel.claro.comissionconector.util.PreComissionResponse;

@RestController
public class PreComissionApi {

	PreComissionResponse preComissionResponse;


	@Autowired
	PreComissionService preComissionService;
	

	@RequestMapping(value = "/ComissionInfo", method = RequestMethod.POST)
	public PreComissionResponse getComissionValue(@RequestBody PreComissionInfo preComissionInfo) {

		preComissionResponse = preComissionService.comissionValue(preComissionInfo);
		return preComissionResponse;

	}

}
