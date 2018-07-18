package com.conecel.claro.salesconector.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.salesconector.util.PreSalesResponse;
import com.conecel.claro.salesconector.util.SalesResponse;
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
		
		SalesResult salesResult = salesResultService.obtieneDetalleVentaPorOrden(preSalesInfo.getorden());
				
		if (salesResult == null) {
			preSalesResponse.setCode("-1");
			preSalesResponse.setMessage("Error al recuperar los datos!");
			preSalesResponse.setResult(null);
			
			return preSalesResponse;
		}
		
		preSalesResponse.setCode("0");
		preSalesResponse.setMessage("OK");
		
		
		SalesResponse salesResponse = new SalesResponse() ;
		
		
		salesResponse.setNoOrden(salesResult.getNoOrden());
		salesResponse.setDescripcionVenta(salesResult.getDescripcionVenta());
		salesResponse.setFechaIngreso(salesResult.getFechaIngreso());
		salesResponse.setCodOficina(salesResult.getCodOficina());
		salesResponse.setOficina(salesResult.getOficina());
		salesResponse.setVendedor(salesResult.getVendedor());
		salesResponse.setIdentificacionCliente(salesResult.getIdentificacionCliente());
		salesResponse.setCliente(salesResult.getCliente());
		salesResponse.setDescripcionProducto(salesResult.getDescripcionProducto());
		salesResponse.setValorProducto(salesResult.getValorProducto());
		salesResponse.setFechaActivacion(salesResult.getFechaActivacion());
		salesResponse.setEstado(salesResult.getEstado());
		salesResponse.setFormaPago(salesResult.getFormaPago());
		salesResponse.setInstitucionFinanciera(salesResult.getInstitucionFinanciera());
		salesResponse.setSolicitud(salesResult.getSolicitud());
		salesResponse.setCuenta(salesResult.getCuenta());
		salesResponse.setUsuarioReg(salesResult.getUsuarioReg());
		
		preSalesResponse.setResult(salesResponse);
		
		}catch  (Exception e)
		{
			preSalesResponse.setCode("-1");
			preSalesResponse.setMessage("Error: " + e.getMessage());
			preSalesResponse.setResult(null);

			log.error("Hubo error", e);
		}
		
		return preSalesResponse;
	}


}
