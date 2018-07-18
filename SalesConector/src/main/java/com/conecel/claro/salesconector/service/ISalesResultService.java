package com.conecel.claro.salesconector.service;

import com.conecel.claro.salesconnector.domain.SalesResult;

public interface ISalesResultService {
	
	SalesResult obtieneDetalleVentaPorOrden(String orden);

}
