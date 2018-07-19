package com.conecel.claro.lotconector.service;

import java.util.List;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconnector.domain.LotResult;

public interface ILotResultService {

	List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo);

}
