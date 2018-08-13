package com.conecel.claro.lotconector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;


@Service
public class PreLotService implements IPreLotService{

	PreLotResponse preLotResponse;
	
	PreLotResponses preLotResponses;
	
	SequenceResponse sequenceResponse;
	

	
	@Autowired
	ILotResultService lotResultService;
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public PreLotResponses regularizationDetail(PreLotInfo preLotInfo) {
		
		preLotResponses= new PreLotResponses();
		
		try {
			
	    List<LotResult> lotResults= lotResultService.obtieneRegulrizaciones(preLotInfo);
	    preLotResponses.setLotResults(lotResults);
	    if (lotResults.isEmpty())
	    {
	    	preLotResponses.setCode("-1");
	    	preLotResponses.setMessage("");
	    	preLotResponses.setLotId("");
	    	preLotResponses.setLotDate("");
	    	preLotResponses.setRecords(0);
	    	return preLotResponses;
	    	
	    }
	    
	    
	    preLotResponses.setCode("200");
	    preLotResponses.setMessage("OK");
	    
	    if (!lotResults.isEmpty()) {
	    	preLotResponses.setLotId(lotResults.get(0).getNumeroLote());
	    	preLotResponses.setLotDate(lotResults.get(0).getFechaLote());
	    	preLotResponses.setRecords(lotResults.size());
	    }
	    	  
	 
	    		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a información de lote: ", e);
		}
		
		
		
		return preLotResponses;
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
			
			
			if(!resultado.booleanValue())
			{
				preLotResponse.setCode("0");
				preLotResponse.setMessage("Error en la actualización!");
				return preLotResponse;
			}
			
			preLotResponse.setCode("201");
	    	preLotResponse.setMessage("Orden(es) actualizada(s)!");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para actualizar lote: ", e);
		}
		
		
		return preLotResponse;
	}
	
	@Override
	public SequenceResponse getSequence() {
		sequenceResponse= new SequenceResponse();
		
		
		try {
			
			String resultado=lotResultService.obtieneSecuencia();
			
			
			if("".equals(resultado))
			{
				sequenceResponse.setCode("0");
				sequenceResponse.setMessage("No se pudo obtener sequencia!");
				return sequenceResponse;
			}
			
			sequenceResponse.setCode("200");
			sequenceResponse.setMessage("OK");
			sequenceResponse.setSequence(resultado);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio para obtener sequencia: ", e);
		}
		
		
		return sequenceResponse;
	}
	
}
