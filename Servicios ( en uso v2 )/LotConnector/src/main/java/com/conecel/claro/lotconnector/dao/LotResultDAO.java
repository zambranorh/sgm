	package com.conecel.claro.lotconnector.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.lotconector.util.LotDetail;
import com.conecel.claro.lotconector.util.LotHeader;
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
		
		
		String queryGenerated="select lot.no_orden, lot.id_cliente Identidad, lot.fecha_activacion, " + 
				"lot.usuario_ingreso, lot.forma_pago, lot.financiera Banco, " + 
				"lot.id_oficina, lot.oficina, lot.dias, lot.estado, " + 
				"lot.motivo, lot.observacion, lot.usuario_reg " + 
				"from rc_lotes2 lot where 1=1 ";
		
		
		try {
			
	    if(!"".equals(preLotInfo.getLotId()))
	    {
	    	queryGenerated= queryGenerated + " and numero_lote= :idLote";
	    	parametros.put("idLote", preLotInfo.getLotId());
	    }
	    
			
	    if(/*preLotInfo.getStartDate() != null ||*/ !"".equals(preLotInfo.getStartDate())) 
	    {
	    	queryGenerated= queryGenerated + " and fecha_activacion>= to_date(:fecha_inicio,'dd/mm/rrrr')"; 
	    	parametros.put("fecha_inicio", preLotInfo.getStartDate());
	    }
	    
	    if(/*preLotInfo.getEndDate() != null ||*/ !"".equals(preLotInfo.getEndDate())) 
	    {
	    	queryGenerated= queryGenerated + " and fecha_activacion<= to_date(:fecha_fin,'dd/mm/rrrr')";
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
	public String creaLote(Lot lote) {
		
		
		try {
			
	   /*if(!"".equals(lote.getLotId()) && !"".equals(lote.getLotDate()+"") && !"".equals(lote.getOrderId()) 
	    		&& !"".equals(lote.getProduct()) && !"".equals(lote.getCustomer())
	    		&& !"".equals(lote.getCustomerId()) && !"".equals(lote.getActivationDate()+"")
	    		&& !"".equals(lote.getLoggedUser()) && !"".equals(lote.getPaymentType())
	    		&& !"".equals(lote.getFinancialInstitution()) && !"".equals(lote.getOfficceId())
	    		&& !"".equals(lote.getOfficce())) {
	    	
	    	
	    	 getEntityManager().persist(lote);
	    	
	
	    }*/
		
			List<String> ordenes=new ArrayList<>();
			
			 if (!"".equals(lote.getLotId()) && null != lote.getLotDate()) {
 			 			
			 			if(!"".equals(lote.getOrderId()) && !"".equals(lote.getProduct())
			 				&& !"".equals(lote.getCustomer()) && !"".equals(lote.getCustomerId())
			 				&& null != lote.getActivationDate() && !"".equals(lote.getLoggedUser())
			 				&& !"".equals(lote.getPaymentType()) && !"".equals(lote.getFinancialInstitution())
			 				&& !"".equals(lote.getOfficceId()) && !"".equals(lote.getOfficce())
			 				&& !"".equals(lote.getStatus())	) {
			 				
			 				getEntityManager().persist(lote);
			 				
			 			}
			 			else 
			 			{
			 				if (!"".equals(lote.getOrderId())) {
			 					ordenes.add(lote.getOrderId());
			 				}
			 				else {
			 					ordenes.add("Numero de orden es obligatorio!");
			 				}
			 				
			 			}
			 			
			 			

			 			
			 			
			 		
			  }
			    
			 else
			    {
			    	return null;
			    }	
		
	 
 	
		
		
		
		
	 
	    

		
	    
	
		
		
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return lote.getLotId();
	}


	@Override
	public boolean actualizaLote(Lot lote) {
		
		int band=0;
		
		try
		{
			
			
			if(/*!"".equals(lote.getLotId()) &&*/ !"".equals(lote.getOrderId())) {
				Lot entityActualizar = this.getEntityManager().find(Lot.class,lote.getOrderId());
				
				
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
				
				if(!"".equals(lote.getRegularized_user())) {
					entityActualizar.setRegularized_user(lote.getRegularized_user());
				}
				
				if(null != lote.getRegularizedDate()) {
					entityActualizar.setRegularizedDate(lote.getRegularizedDate());
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
