package com.conecel.claro.salesconector.service;

import java.util.List;

import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

public interface ISalesResultService {
	
	List<SalesResult> obtieneDetalleVenta(PreSalesInfo preSalesInfo);

}
