package com.conecel.claro.salesconector.service;

import com.conecel.claro.salesconector.util.PreSalesResponse;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

public interface IPreSalesService {

	PreSalesResponse salesDetail(PreSalesInfo preSalesInfo);
	
}
