package com.conecel.claro.comission.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.domain.PreComission;
import com.conecel.claro.comission.dto.ComissionPeriod;

@Service
@Transactional
public class ComissionDAO implements IComissionDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<PreComission> generaComision(ComissionPeriod comissionPeriod) {
		
		List<PreComission> resultado = null;
		
		try
		{
			TypedQuery<PreComission> query = this.getEntityManager().createNamedQuery("PreComission.generaComision", PreComission.class );
			
			if (!"".equals(comissionPeriod.getStartDate()) || !comissionPeriod.getStartDate().isEmpty() &&
					!"".equals(comissionPeriod.getEndDate()) || !comissionPeriod.getEndDate().isEmpty()) {
				query.setParameter(1, comissionPeriod.getStartDate());
				query.setParameter(2, comissionPeriod.getEndDate());
			}
			else
			{
				
				int dia, mes, anio;
				
				dia= Calendar.DATE;
				mes= Calendar.MONTH;
				anio= Calendar.YEAR;
				
				String fecha=dia+"/"+mes+"/"+anio;
				
				System.out.println("Fecha: " + fecha);
				
				query.setParameter(1, fecha);
				query.setParameter(2, fecha);
			}
			
			System.out.println("Query: " + query);
			
			resultado = query.getResultList();
			
			
		}catch(Exception e) {
		e.printStackTrace();	
		}
		
		
		return resultado;
	}

	@Override
	public String insertaComision(Comission comission) {
		
		try
		{
			getEntityManager().persist(comission);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return "OK";
	}

	

}
