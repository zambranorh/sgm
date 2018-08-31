package com.conecel.claro.lotconnector.dao;

import java.util.List;

import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;


public interface ILotResultDAO {

 
	List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo);
	
	String creaLote(Lot lote);
	
	boolean actualizaLote(Lot lote);
	
	String obtieneSecuencia ();




}
