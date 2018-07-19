package com.conecel.claro.lotconnector.dao;

import java.util.List;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconnector.domain.LotResult;

public interface ILotResultDAO {

 
	List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo);


}
