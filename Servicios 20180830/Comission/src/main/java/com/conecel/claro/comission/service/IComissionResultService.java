package com.conecel.claro.comission.service;

import java.util.List;


import com.conecel.claro.comission.domain.ComissionResult;

import com.conecel.claro.comission.dto.ComissionInputs2;

public interface IComissionResultService {

	
	
	public List<ComissionResult> obtieneComisiones2(ComissionInputs2 comissionInputs);
}
