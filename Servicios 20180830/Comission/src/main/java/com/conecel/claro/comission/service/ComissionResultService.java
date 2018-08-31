package com.conecel.claro.comission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.dao.IComissionResultDAO;

import com.conecel.claro.comission.domain.ComissionResult;

import com.conecel.claro.comission.dto.ComissionInputs2;
@Service
public class ComissionResultService implements IComissionResultService{
	
	@Autowired
	IComissionResultDAO comissionResultDAO;



	@Override
	public List<ComissionResult> obtieneComisiones2(ComissionInputs2 comissionInputs) {
		return comissionResultDAO.obtieneComisiones(comissionInputs);
	}

}
