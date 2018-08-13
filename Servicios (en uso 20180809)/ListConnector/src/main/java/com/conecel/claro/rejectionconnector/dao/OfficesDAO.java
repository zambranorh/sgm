package com.conecel.claro.rejectionconnector.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.dto.Offices;
@Service
@Transactional
public class OfficesDAO implements IOfficesDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Offices> obtieneOficnas(ChannelInfo channelInfo) {
		
		List<Offices> resultados= null;
		
		HashMap<String,String> parametros = new HashMap<>();
		
		String queryGenerated="select o.id_oficina, o.descripcion from rc_oficinas o" + 
				"where o.id_canal=:canal" + 
				"and o.estado='A'";
		
		parametros.put("canal", channelInfo.getChannelId());
		
		System.out.println("Canal: "+ channelInfo.getChannelId());
		
		try {
		
		TypedQuery<Offices> query= (TypedQuery<Offices>) this.getEntityManager().createNativeQuery(queryGenerated, Offices.class);
		
		parametros.forEach((k,v)-> query.setParameter(k, v));
		
		resultados= query.getResultList();
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para consulta de oficinas:", e);
			return resultados;
		}
		
		return resultados;
	}



}
