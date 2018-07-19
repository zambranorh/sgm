package com.conecel.claro.lotconector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconnector.dao.ILotResultDAO;
import com.conecel.claro.lotconnector.domain.LotResult;

@Service
public class LotResultService implements ILotResultService{
	
	@Autowired
	ILotResultDAO lotResultDAO;
	
	@Override
	public List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo){
	
		return lotResultDAO.obtieneRegulrizaciones(preLotInfo);
	}

}
