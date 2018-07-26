package com.conecel.claro.comission.service;

import java.util.List;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.dto.ComissionInputs;

public interface IComissionResultService {

	public List<Comission> obtieneComisiones(ComissionInputs comissionInputs);
}
