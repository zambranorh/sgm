package com.conecel.claro.comission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.dao.IComissionDAO;
import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.domain.PreComission2;
import com.conecel.claro.comission.dto.ComissionPeriod;
@Service
public class PreComissionService implements IPreComissionService{
	@Autowired
	IComissionDAO comissionDAO;
	
	
	@Override
	public List<PreComission> generaComision(ComissionPeriod comissionPeriod) {
		
		return comissionDAO.generaComision(comissionPeriod);
	}


	@Override
	public List<PreComission2> generaComision2(ComissionPeriod comissionPeriod) {

		return comissionDAO.generaComision2(comissionPeriod);
	}

}
