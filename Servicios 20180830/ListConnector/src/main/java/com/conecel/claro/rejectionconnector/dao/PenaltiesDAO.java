package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Penalties;
import com.conecel.claro.rejectionconnector.dto.Reasons;
@Service
@Transactional
public class PenaltiesDAO implements IPenaltiesDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Penalties> obitenePenalidades() {
		List<Penalties> resultados= null;
		
		String queryGenerated="select p.id_penalizacion, p.descripcion || '('||p.id_penalizacion||')' DESCRIPCION from rc_penalizaciones p\r\n" + 
				"where p.estado='A'";
		
		try {
			TypedQuery<Penalties>query = (TypedQuery<Penalties>) this.getEntityManager().createNativeQuery(queryGenerated,Penalties.class);
			
			resultados= query.getResultList();
			
			log.info("Penalizaciones recuperadas exitosamente!");
			
			}catch(Exception e) {
				e.printStackTrace();
				log.error("Error en acceso a datos para consulta de penalizaciones:", e);
				return null;
			}
			
			return resultados;
	}

}
