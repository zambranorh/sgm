package com.conecel.claro.salesconnector.dao;

import com.conecel.claro.salesconnector.domain.SalesResult;

public interface ISalesResultDAO {

	SalesResult obtieneDetalleVentaPorOrden(String orden);

}
