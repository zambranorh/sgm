package com.conecel.claro.rejectionconnector.dao;

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
		
	
		
		System.out.println("Canal: "+ channelInfo.getChannelId());
		
		try {
		
		TypedQuery<Offices> query= (TypedQuery<Offices>) this.getEntityManager().createNamedQuery("List.ObtieneOficinas", Offices.class);
		
		if(!"".equals(channelInfo.getChannelId())) {
			query.setParameter(1, channelInfo.getChannelId());
		}
		
		resultados= query.getResultList();
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para consulta de oficinas:", e);
			return resultados;
		}
		
		return resultados;
	}



}
