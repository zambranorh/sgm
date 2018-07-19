package com.conecel.claro.lotconector.service;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconector.util.PreLotResponse;

public interface IPreLotService {

	PreLotResponse regularizationDetail(PreLotInfo preLotInfo);

}
