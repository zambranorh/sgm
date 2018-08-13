package com.conecel.claro.comission.dao;

import java.util.List;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.dto.ComissionPeriod;

public interface IComissionDAO {
	
	public List<PreComission> generaComision(ComissionPeriod comissionPeriod);

	public String insertaComision(Comission comission);

}
