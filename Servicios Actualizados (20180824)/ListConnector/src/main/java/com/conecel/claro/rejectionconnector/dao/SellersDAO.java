package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Reasons;
import com.conecel.claro.rejectionconnector.dto.Sellers;
@Service
@Transactional
public class SellersDAO implements ISellersDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Sellers> obtieneVendedores() {
		
		List<Sellers> resultados= null;
		
		String queryGenerated="select t.id_vendedor, t.nombre\r\n" + 
				"  from rc_vendedor t\r\n" + 
				" where t.estado = 'A'";
		
		
		try {
			TypedQuery<Sellers>query = (TypedQuery<Sellers>) this.getEntityManager().createNativeQuery(queryGenerated,Sellers.class);
			
			resultados= query.getResultList();
			
			log.info("Vendedores recuperados exitosamente!");
			
			}catch(Exception e) {
				e.printStackTrace();
				log.error("Error en acceso a datos para consulta de vendedores:", e);
				return null;
			}
			
			return resultados;
	}

}
