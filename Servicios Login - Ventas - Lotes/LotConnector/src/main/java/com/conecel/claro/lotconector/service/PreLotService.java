package com.conecel.claro.lotconector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconnector.domain.LotResult;

@Service
public class PreLotService implements IPreLotService{

	PreLotResponse preLotResponse;
	

	
	@Autowired
	ILotResultService lotResultService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public PreLotResponse regularizationDetail(PreLotInfo preLotInfo) {
		
		preLotResponse= new PreLotResponse();
		
		try {
			
	    List<LotResult> lotResults= lotResultService.obtieneRegulrizaciones(preLotInfo);
	    preLotResponse.setLotResults(lotResults);
	    if (lotResults.isEmpty())
	    {
	    	preLotResponse.setCode("-1");
	    	preLotResponse.setMessage("Error en recuperar la informacion");
 	    	
	    	return preLotResponse;
	    	
	    }
	    
	    
	    preLotResponse.setCode("0");
    	preLotResponse.setMessage("OK");
	    
 	     
	    		
		}catch(Exception e) {
			
		}
		
		
		
		return preLotResponse;
	}
	
}
