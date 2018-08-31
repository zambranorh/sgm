package com.conecel.claro.comission.dao;

import java.util.List;

import com.conecel.claro.comission.domain.ComissionRules;

public interface IComissionRulesDAO {
	List<ComissionRules> obtieneReglas(String canal, String localidad);
}
