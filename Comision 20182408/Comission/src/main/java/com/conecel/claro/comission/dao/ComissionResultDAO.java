package com.conecel.claro.comission.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.Comission2;
import com.conecel.claro.comission.domain.ComissionResult;
import com.conecel.claro.comission.dto.ComissionInputs;
import com.conecel.claro.comission.dto.ComissionInputs2;

@Service
@Transactional
public class ComissionResultDAO implements IComissionResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@Override
	public List<Comission> obtieneComision(ComissionInputs comissionInputs) {
		
		List<Comission> resultados;
		
		Map<String,String> parametros = new HashMap<>();
		
		String queryGenerated="select c.id_solicitud, c.id_cuenta, c.id_vendedor, c.nombre_vendedor,\r\n" + 
				"c.id_canal, c.id_localidad, c.dias, c.sub_comision, \r\n" + 
				"c.valor_penalizacion, c.total_comision\r\n" + 
				"from rc_comisiones c\r\n" + 
				"where 1=1";
		
		try {
			
		if(!"".equals(comissionInputs.getRequestId())) {
			queryGenerated= queryGenerated + " and c.id_solicitud= :id_solicitud";
			parametros.put("id_solicitud", comissionInputs.getRequestId());
		}
		
		if(!"".equals(comissionInputs.getSellerId())) {
			queryGenerated= queryGenerated + " and c.id_vendedor= :id_vendedor";
			parametros.put("id_vendedor", comissionInputs.getSellerId());
		}
		
		if(!"".equals(comissionInputs.getChannelId())) {
			queryGenerated= queryGenerated + " and c.id_canal= :id_canal";
			parametros.put("id_canal", comissionInputs.getChannelId());
		}
		
		if(!"".equals(comissionInputs.getLocationId())) {
			queryGenerated= queryGenerated + " and c.id_localidad= :id_localidad";
			parametros.put("id_localidad", comissionInputs.getLocationId());
		}
			
		System.out.println("query: " + queryGenerated);
		
		TypedQuery<Comission> query= (TypedQuery<Comission>) this.getEntityManager().createNativeQuery(queryGenerated, Comission.class);
		
		parametros.forEach((k,v)-> query.setParameter(k, v));
		
		resultados = query.getResultList();	
		
		log.info("Comision recuperada exitosamente!");
		
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para obtener comisiones: ",e);
			return null;
		}
		
		return resultados;
	}


	@Override
	public List<ComissionResult> obtieneComisiones(ComissionInputs2 comissionInputs) {
		
		List<ComissionResult> resultados;
		
		Map<String,String> parametros = new HashMap<>();
		
		String queryGenerated="select c.id_solicitud, c.id_localidad, c.nombre_vendedor, c.id_vendedor, \r\n" + 
				"        c.nombre_cliente, c.id_cliente, c.plan, \r\n" + 
				"        c.id_cuenta, c.fecha_ing, c.fecha_reg, c.usuario_reg, \r\n" + 
				"        c.equipo, c.cantidad, c.fecha_act, c.fecha_inc, \r\n" + 
				"        c.usuario_inc, c.motivo, c.valor_penalizacion,  \r\n" + 
				"        c.sub_comision, c.total_comision, c.mensaje from rc_comisiones2 c \r\n" + 
				"        where 1=1";
		
		try {
			
		if(!"".equals(comissionInputs.getSellerId())) {
			queryGenerated= queryGenerated + " and c.id_vendedor= :id_vendedor";
			parametros.put("id_vendedor", comissionInputs.getSellerId());
		}
		
		
		if(!"".equals(comissionInputs.getChannelId())) {
			queryGenerated= queryGenerated + " and c.id_canal= :id_canal";
			parametros.put("id_canal", comissionInputs.getChannelId());
		}
		
		if(!"".equals(comissionInputs.getPenaltyId())) {
			queryGenerated= queryGenerated + " and c.mensaje= :id_penalizacion";
			parametros.put("id_penalizacion", comissionInputs.getPenaltyId());
		}
		
		
		
		
		if(!"".equals(comissionInputs.getStartDate()) && null != comissionInputs.getStartDate()
				
				&& !"null".equals(comissionInputs.getStartDate()))
		{
			queryGenerated= queryGenerated + " and c.fecha_ing>= to_date(:fecha_inicio,'dd/mm/yyyy')";
			parametros.put("fecha_inicio", comissionInputs.getStartDate());
		}
		
		
		if(!"".equals(comissionInputs.getEndDate()) && null != comissionInputs.getEndDate()
				&& !"null".equals(comissionInputs.getEndDate())) {
			queryGenerated= queryGenerated + " and c.fecha_ing<= to_date(:fecha_fin,'dd/mm/yyyy')";
			parametros.put("fecha_fin", comissionInputs.getEndDate());
		}
		
		
			
		System.out.println("query: " + queryGenerated);
		
		TypedQuery<ComissionResult> query= (TypedQuery<ComissionResult>) this.getEntityManager().createNativeQuery(queryGenerated, ComissionResult.class);
		
		parametros.forEach((k,v)-> query.setParameter(k, v));
		
		resultados = query.getResultList();	
		
		log.info("Comision recuperada exitosamente!");
		
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para obtener comisiones: ",e);
			return null;
		}
		
		return resultados;
	}

}
