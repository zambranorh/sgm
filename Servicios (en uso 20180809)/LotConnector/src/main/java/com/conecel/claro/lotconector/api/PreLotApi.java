package com.conecel.claro.lotconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.lotconector.service.IInsertLotDetailService;
import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.PreLotInfo;
//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
public class PreLotApi {
	
	PreLotResponse preLotResponse;
	
	PreLotResponses preLotResponses;
	
	SequenceResponse sequenceResponse;
	

	
	@Autowired
	IInsertLotDetailService insertLotDetailService;
	
	@RequestMapping(value = "/LotInfo", method = RequestMethod.POST)
	public PreLotResponses getRegDetail(@RequestBody PreLotInfo preLotInfo)
	{
		preLotResponses= insertLotDetailService.regularizationDetail(preLotInfo);
		return preLotResponses;
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
	
	@RequestMapping(value = "/GetSequence", method = RequestMethod.GET)
	public SequenceResponse getSequence() {
		
		sequenceResponse= insertLotDetailService.getSequence();
		
		return sequenceResponse;
		
	}
	

}
