package com.conecel.claro.comission.service;


import com.conecel.claro.comission.dto.ComissionInputs;
import com.conecel.claro.comission.dto.ComissionPeriod;
import com.conecel.claro.comission.util.ComissionResponse;
import com.conecel.claro.comission.util.GeneratedComissionResponse;

public interface IComissionService {

	public GeneratedComissionResponse generaComision(ComissionPeriod comissionPeriod);
	
	public ComissionResponse getComissions(ComissionInputs comissionInputs);
}
