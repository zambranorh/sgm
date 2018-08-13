package com.conecel.claro.lotconector.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.lotconector.util.LotDetail;
import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconector.util.UpdateLotDetail;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotId;
import com.conecel.claro.lotconnector.dto.PreLotInfo;
 
@Service	
public class InsertLotDetailService implements IInsertLotDetailService {
	
	@Autowired
	IPreLotService preLotService;
	
	PreLotResponse preLotResponse= new PreLotResponse();
	
	SequenceResponse sequenceResponse = new SequenceResponse();
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public PreLotResponse grabarMaestroDetalle(LotHeader lotHeader ) {
			
		try {
		
		for(LotDetail lotDetail : lotHeader.getLotDetail()) {
			Lot lot = new Lot();

			LotId lotId = new LotId();
			lotId.setLotId(lotHeader.getLotId());
			lotId.setOrderId(lotDetail.getOrderId());
			lot.setId(lotId);
			lot.setLotDate(lotHeader.getLotDate());
			lot.setProduct(lotDetail.getProduct());
			lot.setCustomer(lotDetail.getCustomer());
			lot.setCustomerId(lotDetail.getCustomerId());
			lot.setActivationDate(lotDetail.getActivationDate());
			lot.setLoggedUser(lotDetail.getLoggedUser());
			lot.setPaymentType(lotDetail.getPaymentType());
			lot.setFinancialInstitution(lotDetail.getFinancialInstitution());
			lot.setOfficceId(lotDetail.getOfficceId());
			lot.setOfficce(lotDetail.getOfficce());
			lot.setStatus(lotDetail.getStatus());
				
			preLotResponse = preLotService.lotCreation(lot);
			
		}	
			 
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de creación de lote: ", e);
		}
		
		
		return preLotResponse;
		
	}


	@Override
	public PreLotResponses regularizationDetail(PreLotInfo preLotInfo) {
		return preLotService.regularizationDetail(preLotInfo);
	}


	@Override
	public PreLotResponse lotUpdate(Lot lote) {
		return preLotService.lotUpdate(lote);
	}
	


	@Override
	public PreLotResponse actualizarMaestroDetalle(UpdateLotHeader updateLotHeader) {
		try {
		for(UpdateLotDetail updateLotDetail : updateLotHeader.getUpdateLotDetail()) {
			Lot lot = new Lot();
			LotId lotId = new LotId();
			
			lot.setRegularized_user(updateLotHeader.getRegularized_user());
			lot.setRegularizedDate(updateLotHeader.getRegularizedDate());
			lotId.setOrderId(updateLotDetail.getOrderId());
			lotId.setLotId(updateLotHeader.getLotId());
			lot.setId(lotId);
			lot.setStatus(updateLotDetail.getStatus());
			lot.setReason(updateLotDetail.getReason());
			lot.setObservation(updateLotDetail.getObservation());
		
			preLotResponse = preLotService.lotUpdate(lot);
	}
	}catch(Exception e) {
		e.printStackTrace();
		log.error("Error en servicio de actualización de lote: ", e);
	}
		
		return preLotResponse;

	}
	
	@Override
	public SequenceResponse getSequence() {
		
		try {
			sequenceResponse = preLotService.getSequence();
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de generacion de secuencia de lote: ", e);
			
		}
		return sequenceResponse;
	}
	
	

	
}
	
	

	
	


