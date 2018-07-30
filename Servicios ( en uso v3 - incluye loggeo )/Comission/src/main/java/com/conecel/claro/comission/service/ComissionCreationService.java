package com.conecel.claro.comission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.dao.IComissionDAO;
import com.conecel.claro.comission.domain.Comission;
@Service
public class ComissionCreationService implements IComissionCreationService{

	@Autowired
	IComissionDAO comissionCreationService;
	
	
	@Override
	public String insertaComisiones(Comission comission) {
		
		return comissionCreationService.insertaComision(comission);
	}

}
