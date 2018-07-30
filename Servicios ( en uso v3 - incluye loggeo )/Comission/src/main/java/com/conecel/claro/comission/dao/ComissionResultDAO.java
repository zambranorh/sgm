package com.conecel.claro.comission.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.dto.ComissionInputs;

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
		
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para obtener comisiones: ",e);
			return null;
		}
		
		return resultados;
	}

}
