package com.conecel.claro.lotconector.service;

import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

public interface IInsertLotDetailService {

	PreLotResponses regularizationDetail(PreLotInfo preLotInfo);

	PreLotResponse grabarMaestroDetalle(LotHeader lotHeader);

	PreLotResponse lotUpdate(Lot lote);
	
	PreLotResponse actualizarMaestroDetalle(UpdateLotHeader updateLotHeader);

	SequenceResponse getSequence();
	

}
