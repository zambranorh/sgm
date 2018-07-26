package com.conecel.claro.comission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.dao.IComissionRulesDAO;
import com.conecel.claro.comission.domain.ComissionRules;
@Service
public class ComissionRulesService implements IComissionRulesService{
	
	@Autowired
	IComissionRulesDAO comissionRules;

	@Override
	public List<ComissionRules> obtieneComisionPorOrdenYCuenta(String canal, String localidad) {
	
		return comissionRules.obtieneReglas(canal, localidad);
	}

}
