package com.conecel.claro.comission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.dao.IComissionResultDAO;
import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.dto.ComissionInputs;
@Service
public class ComissionResultService implements IComissionResultService{
	
	@Autowired
	IComissionResultDAO comissionResultDAO;

	@Override
	public List<Comission> obtieneComisiones(ComissionInputs comissionInputs) {
		return comissionResultDAO.obtieneComision(comissionInputs);
	}

}
