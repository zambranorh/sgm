package com.conecel.claro.lotconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconector.service.IPreLotService;
import com.conecel.claro.lotconector.util.PreLotResponse;

@RestController
public class PreLotApi {
	
	PreLotResponse preLotResponse;
	@Autowired
	IPreLotService preLotService;
	
	@RequestMapping(value = "/LotInfo", method = RequestMethod.POST)
	public PreLotResponse getRegDetail(@RequestBody PreLotInfo preLotInfo)
	{
		preLotResponse= preLotService.regularizationDetail(preLotInfo);
		return preLotResponse;
	}

}
