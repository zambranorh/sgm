package com.conecel.claro.comission.service;



import com.conecel.claro.comission.dto.ComissionInputs2;
import com.conecel.claro.comission.dto.ComissionPeriod;

import com.conecel.claro.comission.util.ComissionResponse2;
import com.conecel.claro.comission.util.GeneratedComissionResponse;

public interface IComissionService {

	//public GeneratedComissionResponse generaComision(ComissionPeriod comissionPeriod);
	
	public GeneratedComissionResponse generaComision2(ComissionPeriod comissionPeriod);
	
	//public ComissionResponse getComissions(ComissionInputs comissionInputs);
	
	public ComissionResponse2 getComissions2(ComissionInputs2 comissionInputs);
}
