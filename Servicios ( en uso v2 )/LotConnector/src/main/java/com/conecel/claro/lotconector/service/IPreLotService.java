package com.conecel.claro.lotconector.service;

import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

public interface IPreLotService {

	PreLotResponse regularizationDetail(PreLotInfo preLotInfo);
	
	PreLotResponse lotCreation(Lot lote);
	
	PreLotResponse lotUpdate(Lot lote);

}
