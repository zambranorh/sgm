package com.conecel.claro.lotconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.lotconector.service.IInsertLotDetailService;
import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

@RestController
public class PreLotApi {
	
	PreLotResponse preLotResponse;
	

	
	@Autowired
	IInsertLotDetailService insertLotDetailService;
	
	@RequestMapping(value = "/LotInfo", method = RequestMethod.POST)
	public PreLotResponse getRegDetail(@RequestBody PreLotInfo preLotInfo)
	{
		preLotResponse= insertLotDetailService.regularizationDetail(preLotInfo);
		return preLotResponse;
	}
	
	@RequestMapping(value = "/LotCreation", method = RequestMethod.POST)
	public PreLotResponse lotCreation(@RequestBody LotHeader lotHeader) {
		
		
		preLotResponse = insertLotDetailService.grabarMaestroDetalle(lotHeader);
		
		return preLotResponse;
		
	}
	
	@RequestMapping(value = "/LotUpdate", method = RequestMethod.POST)
	public PreLotResponse lotUpdate(@RequestBody UpdateLotHeader updateLotHeader) {
		preLotResponse= insertLotDetailService.actualizarMaestroDetalle(updateLotHeader);
		
		return preLotResponse;
		
	}

}
