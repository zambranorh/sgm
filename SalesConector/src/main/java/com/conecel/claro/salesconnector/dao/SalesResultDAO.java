package com.conecel.claro.salesconnector.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.salesconnector.domain.SalesResult;



@Service
@Transactional
public class SalesResultDAO implements ISalesResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public SalesResult obtieneDetalleVentaPorOrden(String orden) {
		
		SalesResult resultado;
			
		
		try {
			
		System.out.println("orden: " + orden);
			
		TypedQuery<SalesResult> query= this.getEntityManager().createNamedQuery("SalesResult.obtieneDetalleVentaPorOrden", SalesResult.class);
		query.setParameter(1, orden);
		
		

		
		
	    resultado = query.getSingleResult();
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return resultado;
	}
	

}
