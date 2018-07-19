package com.conecel.claro.salesconnector.dao;

import java.util.List;

import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

public interface ISalesResultDAO {

	List<SalesResult> obtieneDetalleVenta(PreSalesInfo preSalesInfo);

}
