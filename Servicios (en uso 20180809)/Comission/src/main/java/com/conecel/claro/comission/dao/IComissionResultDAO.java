package com.conecel.claro.comission.dao;

import java.util.List;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.dto.ComissionInputs;

public interface IComissionResultDAO {
	
	List<Comission> obtieneComision(ComissionInputs comissionInputs);

}
