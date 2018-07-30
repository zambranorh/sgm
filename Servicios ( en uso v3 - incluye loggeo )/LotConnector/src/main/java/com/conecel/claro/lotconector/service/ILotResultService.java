package com.conecel.claro.lotconector.service;

import java.util.List;


import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

public interface ILotResultService {

	List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo);
	
	String creaLote (Lot lote);
	
	Boolean actualizaLote (Lot lote);

}
