package com.conecel.claro.comission.service;

import java.util.List;

import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.dto.ComissionPeriod;

public interface IPreComissionService {

	public List<PreComission> generaComision(ComissionPeriod comissionPeriod);
}
