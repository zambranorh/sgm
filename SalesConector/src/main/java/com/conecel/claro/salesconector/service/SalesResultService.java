package com.conecel.claro.salesconector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.salesconnector.dao.ISalesResultDAO;
import com.conecel.claro.salesconnector.domain.SalesResult;

@Service
public class SalesResultService implements ISalesResultService{
	
	
	@Autowired
	ISalesResultDAO salesResultDAO;

	@Override
	public SalesResult obtieneDetalleVentaPorOrden(String orden) {
 		
 		return salesResultDAO.obtieneDetalleVentaPorOrden(orden);
	}

	
}
