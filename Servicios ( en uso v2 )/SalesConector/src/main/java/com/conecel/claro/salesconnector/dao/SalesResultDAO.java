package com.conecel.claro.salesconnector.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;



@Service
@Transactional
public class SalesResultDAO implements ISalesResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public List<SalesResult> obtieneDetalleVenta(PreSalesInfo preSalesInfo) {
		
		
		HashMap<String,String> parametros = new HashMap<>();
		
		List<SalesResult> resultado;
		
		String queryGenerated="select rownum id, \r\n" + 
				"            vta.numero_orden NoOrden, \r\n" + 
				"        vta.descripcion descripcionVenta, \r\n" + 
				"               vta.fecha_ingreso, \r\n" + 
				"               vta.id_oficina      CodOficina, \r\n" + 
				"               ofi.descripcion      Oficina, \r\n" + 
				"               vend.nombre          Vendedor, \r\n" + 
				"               vta.id_cliente IdentificacionCliente, \r\n" + 
				"               cli.nombre           Cliente, \r\n" + 
				"               prod.descripcion descripcionProducto, \r\n" + 
				"               vta.valor_producto, \r\n" + 
				"               vta.fecha_activacion, \r\n" + 
				"               vta.estado, \r\n" + 
				"               fp.descripcion       FormaPago, \r\n" + 
				"               finc.descripcion     InstitucionFinanciera, \r\n" + 
				"               vta.id_solicitud     NoSolicitud, \r\n" + 
				"               vta.id_cuenta        Cuenta, \r\n" + 
				"               vta.id_usuario_reg   UsuarioReg \r\n" + 
				"          from rc_venta        vta, \r\n" + 
				"               rc_oficinas     ofi, \r\n" + 
				"               rc_vendedor     vend, \r\n" + 
				"               rc_cliente      cli, \r\n" + 
				"               rc_producto     prod, \r\n" + 
				"               rc_formas_pagos fp, \r\n" + 
				"               rc_financieras  finc\r\n" + 
				"         where vta.id_oficina = ofi.id_oficina \r\n" + 
				"           and vta.id_vendedor = vend.id_vendedor \r\n" + 
				"           and vta.id_cliente = cli.id_cliente \r\n" + 
				"           and vta.id_producto = prod.id_producto \r\n" + 
				"           and vta.id_forma_pago = fp.codigo \r\n" + 
				"           and vta.id_financiera = finc.id_financiera\r\n" + 
				"           and vta.numero_orden not in  \r\n" + 
				"           (select lot.no_orden from rc_lotes2 lot)";
				
			
		
		try {
			
		if(!"".equals(preSalesInfo.getStartDate())) 
		{
			queryGenerated= queryGenerated + " and vta.fecha_activacion>= to_date(:fecha_inicio,'dd/mm/yyyy')";
			parametros.put("fecha_inicio", preSalesInfo.getStartDate());
					
		}
		
		if(!"".equals(preSalesInfo.getEndDate())) 
		{
			queryGenerated= queryGenerated + " and vta.fecha_activacion<= to_date(:fecha_fin,'dd/mm/yyyy')";
			parametros.put("fecha_fin", preSalesInfo.getEndDate());
					
					
		}
		
		if(!"".equals(preSalesInfo.getOrder())) 
		{
			queryGenerated= queryGenerated + " and vta.numero_orden= :orden";
			parametros.put("orden",preSalesInfo.getOrder());
					
		}
		
		if(!"".equals(preSalesInfo.getOfficceId())) 
		{
			queryGenerated= queryGenerated + " and vta.id_oficina= :oficina";
			parametros.put("oficina",preSalesInfo.getOfficceId());
					
		}
		
		if(!"".equals(preSalesInfo.getChannelId())) 
		{
			queryGenerated= queryGenerated + " and ofi.id_canal= :canal";
			parametros.put("canal", preSalesInfo.getChannelId());
					
		}
		
		queryGenerated=queryGenerated + " order by vta.numero_orden asc";
		
		System.out.println("query: " + queryGenerated);
			
			
		TypedQuery<SalesResult> query= (TypedQuery<SalesResult>)this.getEntityManager().createNativeQuery(queryGenerated, SalesResult.class);
		
		parametros.forEach((k,v)-> query.setParameter(k, v));
		

		
		
	    resultado = query.getResultList();
	    
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return resultado;
	}
	

}
