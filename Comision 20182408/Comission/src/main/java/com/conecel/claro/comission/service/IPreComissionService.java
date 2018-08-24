package com.conecel.claro.comission.service;

import java.util.List;

import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.domain.PreComission2;
import com.conecel.claro.comission.dto.ComissionPeriod;

public interface IPreComissionService {

	public List<PreComission> generaComision(ComissionPeriod comissionPeriod);
	
	public List<PreComission2> generaComision2(ComissionPeriod comissionPeriod);
}
