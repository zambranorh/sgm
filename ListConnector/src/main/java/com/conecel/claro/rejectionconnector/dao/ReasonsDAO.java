package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Reasons;
@Service
@Transactional
public class ReasonsDAO implements IReasonsDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Reasons> obtieneMotivos() {
		
		List<Reasons> resultados = null;
		
		String queryGenerated="select t.id_motivo, t.descripcion\r\n" + 
				"  from rc_motivos_penalizacion t\r\n" + 
				" where t.estado = 'A'";
		
		try {
		TypedQuery<Reasons>query = (TypedQuery<Reasons>) this.getEntityManager().createNativeQuery(queryGenerated,Reasons.class);
		
		resultados= query.getResultList();
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en acceso a datos para consulta de motivos:", e);
			return null;
		}
		
		return resultados;
	}

}
