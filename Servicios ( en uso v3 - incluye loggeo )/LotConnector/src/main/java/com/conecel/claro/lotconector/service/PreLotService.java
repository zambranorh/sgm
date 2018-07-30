package com.conecel.claro.lotconector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

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
	    	preLotResponse.setMessage("");
 	    	
	    	return preLotResponse;
	    	
	    }
	    
	    
	    preLotResponse.setCode("200");
    	preLotResponse.setMessage("OK");
	    
 	     
	    		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a información de lote: ", e);
		}
		
		
		
		return preLotResponse;
	}
	@Override
	public PreLotResponse lotCreation(Lot lote) {
		
		preLotResponse= new PreLotResponse();
		
		try {
			
			
			String resultado= lotResultService.creaLote(lote);
			
			
			if("".equals(resultado) || resultado.isEmpty())
			{
				preLotResponse.setCode("0");
				preLotResponse.setMessage("No se creo lote!");
				return preLotResponse;
			}
			
			preLotResponse.setCode("201");
	    	preLotResponse.setMessage("Lote creado: "+ resultado);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para crear lote: ", e);
		}
		
		
		return preLotResponse;
	}
	@Override
	public PreLotResponse lotUpdate(Lot lote) {
		preLotResponse= new PreLotResponse();
		
		try {
			
			Boolean resultado= lotResultService.actualizaLote(lote);
			
			System.out.println("Ejecucion: " + resultado);
			
			if(!resultado.booleanValue())
			{
				preLotResponse.setCode("0");
				preLotResponse.setMessage("No se actualizo la orden!");
				return preLotResponse;
			}
			
			preLotResponse.setCode("201");
	    	preLotResponse.setMessage("Orden actualizada!");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para actualizar lote: ", e);
		}
		
		
		return preLotResponse;
	}
	
	
	
}
