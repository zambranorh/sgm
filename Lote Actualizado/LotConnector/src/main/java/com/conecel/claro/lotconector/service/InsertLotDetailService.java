package com.conecel.claro.lotconector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.lotconector.util.LotDetail;
import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.UpdateLotDetail;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.PreLotInfo;
 
@Service	
public class InsertLotDetailService implements IInsertLotDetailService {
	
	@Autowired
	IPreLotService preLotService;
	
	PreLotResponse preLotResponse= new PreLotResponse();
	
	
	@Override
	public PreLotResponse grabarMaestroDetalle(LotHeader lotHeader ) {
			
		
		
		for(LotDetail lotDetail : lotHeader.getLotDetail()) {
			Lot lot = new Lot();

			lot.setLotId(lotHeader.getLotId());
			lot.setLotDate(lotHeader.getLotDate());
			
			lot.setOrderId(lotDetail.getOrderId());
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
		
		
		return preLotResponse;
		
	}


	@Override
	public PreLotResponse regularizationDetail(PreLotInfo preLotInfo) {
		return preLotService.regularizationDetail(preLotInfo);
	}


	@Override
	public PreLotResponse lotUpdate(Lot lote) {
		return preLotService.lotUpdate(lote);
	}
	


	@Override
	public PreLotResponse actualizarMaestroDetalle(UpdateLotHeader updateLotHeader) {
		
		for(UpdateLotDetail updateLotDetail : updateLotHeader.getUpdateLotDetail()) {
			Lot lot = new Lot();
			
			lot.setRegularized_user(updateLotHeader.getRegularized_user());
			lot.setRegularizedDate(updateLotHeader.getRegularizedDate());

			lot.setOrderId(updateLotDetail.getOrderId());
			lot.setStatus(updateLotDetail.getStatus());
			lot.setReason(updateLotDetail.getReason());
			lot.setObservation(updateLotDetail.getObservation());
		
			preLotResponse = preLotService.lotUpdate(lot);
	}
		
		return preLotResponse;

	}
	
	
}
	
	

	
	


