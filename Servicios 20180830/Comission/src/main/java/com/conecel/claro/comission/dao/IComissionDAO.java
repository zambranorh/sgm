package com.conecel.claro.comission.dao;

import java.util.List;


import com.conecel.claro.comission.domain.Comission2;

import com.conecel.claro.comission.domain.PreComission2;
import com.conecel.claro.comission.dto.ComissionPeriod;

public interface IComissionDAO {
	
	//
	
	public List<PreComission2> generaComision2(ComissionPeriod comissionPeriod);

	//
	
	public String insertaComision2(Comission2 comission);

}
