package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.PaymentType;


@Service
@Transactional
public class PaymentTypeDAO implements IPaymentTypeDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<PaymentType> obtieneFormasPago() {
		
		List<PaymentType> resultados=null;
		
		String queryGenerated="select fp.codigo, fp.descripcion from rc_formas_pagos fp";
		
		try {
			TypedQuery<PaymentType>query = (TypedQuery<PaymentType>) this.getEntityManager().createNativeQuery(queryGenerated,PaymentType.class);
			
			resultados= query.getResultList();
			
			log.info("Formas de pago recuperadas exitosamente!");
			
			}catch(Exception e) {
				e.printStackTrace();
				log.error("Error en acceso a datos para consulta de formas de pago:", e);
				return null;
			}
			
			return resultados;
		
	}

}
