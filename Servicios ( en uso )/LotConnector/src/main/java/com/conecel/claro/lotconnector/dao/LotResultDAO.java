package com.conecel.claro.lotconnector.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;




@Service
@Transactional
public class LotResultDAO implements ILotResultDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	

	@Override
	public List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo) {
		
		List<LotResult> resultados;
		
		Map<String,String> parametros = new HashMap<>();
		
		
		String queryGenerated="select to_char(rownum) id, lot.id_cliente Identidad, lot.fecha_activacion, " + 
				"lot.usuario_ingreso, lot.forma_pago, lot.financiera Banco, " + 
				"lot.id_oficina, lot.oficina, lot.dias, lot.estado, " + 
				"lot.motivo, lot.observacion, lot.usuario_reg " + 
				"from rc_lotes lot where 1=1 ";
		
		
		try {
			
	    if(/*preLotInfo.getStartDate() != null ||*/ !"".equals(preLotInfo.getStartDate())) 
	    {
	    	queryGenerated= queryGenerated + " and fecha_activacion>= :fecha_inicio"; 
	    	parametros.put("fecha_inicio", preLotInfo.getStartDate());
	    }
	    
	    if(/*preLotInfo.getEndDate() != null ||*/ !"".equals(preLotInfo.getEndDate())) 
	    {
	    	queryGenerated= queryGenerated + " and fecha_activacion<= :fecha_fin";
	    	parametros.put("fecha_fin",preLotInfo.getEndDate());
	    }
	    
	    if(/*preLotInfo.getOrder() != null ||*/ !"".equals(preLotInfo.getOrderId())) 
	    {
	    	queryGenerated= queryGenerated + " and no_orden= :orden";
	    	parametros.put("orden", preLotInfo.getOrderId());
	    	
	    }
	    
	    if(/*preLotInfo.getCustomerId() != null ||*/ !"".equals(preLotInfo.getCustomerId())) 
	    {
	    	queryGenerated= queryGenerated + " and id_cliente= :id_cliente";
	    	parametros.put("id_cliente",preLotInfo.getCustomerId());
	    }
	    
	    if(/*preLotInfo.getSalesChannel() != null ||*/ !"".equals(preLotInfo.getSalesChannel())) 
	    {
	    	queryGenerated= queryGenerated + " and id_oficina= :id_oficina";
	    	parametros.put("id_oficina", preLotInfo.getSalesChannel());
	    }
	    
	    if(/*preLotInfo.getPaymentType() != null ||*/ !"".equals(preLotInfo.getPaymentType())) 
	    {
	    	queryGenerated= queryGenerated + " and forma_pago= :forma_pago";
	    	parametros.put("forma_pago",preLotInfo.getPaymentType());
	    }
	    
	    if(/*preLotInfo.getFinancialInstitution() != null ||*/ !"".equals(preLotInfo.getFinancialInstitution())) 
	    {
	    	queryGenerated= queryGenerated + " and financiera= :banco ";
	    	parametros.put("banco", preLotInfo.getFinancialInstitution());
	    }
	    
		System.out.println("query: " + queryGenerated);

			
			TypedQuery<LotResult> query= (TypedQuery<LotResult>) this.getEntityManager().createNativeQuery(queryGenerated, LotResult.class);
			
			parametros.forEach((k,v)-> query.setParameter(k, v));
			
			resultados = query.getResultList();	
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return resultados;
	}


	
	@Override
	public boolean creaLote(Lot lote) {
		
		
		try {
			
	    if(!"".equals(lote.getLotId()) && !"".equals(lote.getLotDate()+"") && !"".equals(lote.getOrderId()) 
	    		&& !"".equals(lote.getProduct()) && !"".equals(lote.getCustomer())
	    		&& !"".equals(lote.getCustomerId()) && !"".equals(lote.getActivationDate()+"")
	    		&& !"".equals(lote.getLoggedUser()) && !"".equals(lote.getPaymentType())
	    		&& !"".equals(lote.getFinancialInstitution()) && !"".equals(lote.getOfficceId())
	    		&& !"".equals(lote.getOfficce())) {
	    	
	    	
	    	 getEntityManager().persist(lote);
	    	
	
	    }
	    else
	    {
	    	return false;
	    }
	    

		
	    
	
		
		
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	@Override
	public boolean actualizaLote(Lot lote) {
		
		int band=0;
		
		try
		{
			
			
			if(!"".equals(lote.getLotId())) {
				Lot entityActualizar = this.getEntityManager().find(Lot.class,lote.getLotId());
				
				
				if(!"".equals(lote.getStatus())) {
					
					entityActualizar.setStatus(lote.getStatus());
					band=1;
			    		
				}
				
				if(!"".equals(lote.getReason())) {
					entityActualizar.setReason(lote.getReason());
					band=1;
				}
					
				if(!"".equals(lote.getObservation())) {
					entityActualizar.setObservation(lote.getObservation());
					band=1;
				}
				  	
				
				
				if(band==1) {
					this.getEntityManager().merge(entityActualizar);	
				}else {
					return false;
				}
			
				
			}else
			{
				return false;
			}
			
			
	  
		
		}catch(Exception e) {
			e.getMessage();
		}
	  
	  
		
		return true;
	}
}
