package com.conecel.claro.comission.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.ComissionRules;
@Service
@Transactional
public class ComissionRulesDAO implements IComissionRulesDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<ComissionRules> obtieneReglas(String canal, String localidad) {
		
		List<ComissionRules> resultado = null;
		
		try
		{
			TypedQuery<ComissionRules> query = this.getEntityManager().createNamedQuery("ComissionRules.obtieneReglas", ComissionRules.class );
			
			
				query.setParameter(1, canal);
				query.setParameter(2, localidad);
			
			
			System.out.println("Query: " + query);
			
			resultado= query.getResultList();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return resultado;
	}
}
