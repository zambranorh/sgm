package com.conecel.claro.salesconector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.salesconnector.dao.ISalesResultDAO;
import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;

@Service
public class SalesResultService implements ISalesResultService{
	
	
	@Autowired
	ISalesResultDAO salesResultDAO;

	@Override
	public List<SalesResult> obtieneDetalleVenta(PreSalesInfo preSalesInfo) {
 		
 		return salesResultDAO.obtieneDetalleVenta(preSalesInfo);
	}

	
}
