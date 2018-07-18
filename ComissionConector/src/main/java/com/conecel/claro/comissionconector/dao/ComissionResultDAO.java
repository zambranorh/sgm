package com.conecel.claro.comissionconector.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.conecel.claro.comissionconnector.domain.ComissionResult;
@Service
@Transactional
public class ComissionResultDAO implements IComissionResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}




	@Override
	public ComissionResult obtieneComisionPorSolicitudYCuenta(String solicitud, String cuenta) {
		
		ComissionResult resultado;
			
		
		try {
			
		
			
		TypedQuery<ComissionResult> query= this.getEntityManager().createNamedQuery("ComissionResult.obtieneComisionPorSolicitudYCuenta", ComissionResult.class);
		query.setParameter(1, solicitud);
		query.setParameter(2, cuenta);
		

		
		
	    resultado = query.getSingleResult();
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return resultado;
	}
	


}
