package com.conecel.claro.salesconector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.salesconector.util.PreSalesResponse;
import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

@Service
public class PreSalesService implements IPreSalesService{
	
	PreSalesResponse preSalesResponse;
	

	
	@Autowired
	ISalesResultService  salesResultService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public PreSalesResponse salesDetail(PreSalesInfo preSalesInfo) {
		preSalesResponse=new PreSalesResponse();
		try {
		
		List<SalesResult> salesResult = salesResultService.obtieneDetalleVenta(preSalesInfo);
		preSalesResponse.setSalesResult(salesResult); 

		if (salesResult == null) {
			preSalesResponse.setCode("-1");
			preSalesResponse.setMessage("No se encontraron datos!");
			return preSalesResponse;
		}
		
		preSalesResponse.setCode("0");
		preSalesResponse.setMessage("OK");
		preSalesResponse.setRecords(salesResult.size());
		
  		
	
		
		
		}catch  (Exception e)
		{
			preSalesResponse.setCode("-1");
			preSalesResponse.setMessage("Error: " + e.getMessage());
			log.error("Error en servicio para obtener detalle de ventas: ", e);
		}
		
		return preSalesResponse;
	}


}
