package com.conecel.claro.comission.dao;

import java.util.List;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.ComissionResult;
import com.conecel.claro.comission.dto.ComissionInputs;
import com.conecel.claro.comission.dto.ComissionInputs2;

public interface IComissionResultDAO {
	
	List<Comission> obtieneComision(ComissionInputs comissionInputs);
	
	List<ComissionResult> obtieneComisiones(ComissionInputs2 comissionInputs);

}
