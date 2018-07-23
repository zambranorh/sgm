package com.conecel.claro.lotconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.lotconector.service.IPreLotService;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

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
	
	@RequestMapping(value = "/LotCreation", method = RequestMethod.POST)
	public PreLotResponse lotCreation(@RequestBody Lot lote) {
		preLotResponse= preLotService.lotCreation(lote);
		
		return preLotResponse;
		
	}
	
	@RequestMapping(value = "/LotUpdate", method = RequestMethod.POST)
	public PreLotResponse lotUpdate(@RequestBody Lot lote) {
		preLotResponse= preLotService.lotUpdate(lote);
		
		return preLotResponse;
		
	}

}
