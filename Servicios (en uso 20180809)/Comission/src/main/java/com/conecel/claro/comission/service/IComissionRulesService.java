package com.conecel.claro.comission.service;

import java.util.List;

import com.conecel.claro.comission.domain.ComissionRules;

public interface IComissionRulesService {

	public List<ComissionRules> obtieneComisionPorOrdenYCuenta(String canal, String localidad);
}
