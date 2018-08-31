package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Channel;
import com.conecel.claro.rejectionconnector.dto.Penalties;
@Service
@Transactional
public class ChannelDAO implements IChannelDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public List<Channel> obtieneCanales() {
		
		List<Channel> resultados=null;
		
		String queryGenerated="select c.id_canal, c.descripcion from rc_canal c";
		
		try {
			TypedQuery<Channel>query = (TypedQuery<Channel>) this.getEntityManager().createNativeQuery(queryGenerated,Channel.class);
			
			resultados= query.getResultList();
			
			log.info("Canales recuperadas exitosamente!");
			
			}catch(Exception e) {
				e.printStackTrace();
				log.error("Error en acceso a datos para consulta de canales:", e);
				return null;
			}
			
			return resultados;
	}

}
