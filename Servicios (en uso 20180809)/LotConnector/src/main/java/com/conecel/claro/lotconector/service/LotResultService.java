package com.conecel.claro.lotconector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.lotconnector.dao.ILotResultDAO;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;


@Service
public class LotResultService implements ILotResultService{
	
	@Autowired
	ILotResultDAO lotResultDAO;
	
	@Override
	public List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo){
	
		return lotResultDAO.obtieneRegulrizaciones(preLotInfo);
	}

	@Override
	public String creaLote(Lot lote) {
		
		return lotResultDAO.creaLote(lote);
	}

	@Override
	public Boolean actualizaLote(Lot lote) {
		
		return lotResultDAO.actualizaLote(lote);
	}
	
	@Override
	public String obtieneSecuencia() {
		return lotResultDAO.obtieneSecuencia();
				
	}

}
