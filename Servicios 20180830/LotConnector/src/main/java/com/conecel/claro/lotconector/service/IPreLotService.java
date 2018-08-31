package com.conecel.claro.lotconector.service;

import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

public interface IPreLotService {

	PreLotResponses regularizationDetail(PreLotInfo preLotInfo);
	
	PreLotResponse lotCreation(Lot lote);
	
	PreLotResponse lotUpdate(Lot lote);
	
	SequenceResponse getSequence();
	
	

}
