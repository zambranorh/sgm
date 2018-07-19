package com.conecel.claro.lotconnector.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.conecel.claro.loconnector.dto.PreLotInfo;
import com.conecel.claro.lotconnector.domain.LotResult;




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
	    
	    if(/*preLotInfo.getOrder() != null ||*/ !"".equals(preLotInfo.getOrder())) 
	    {
	    	queryGenerated= queryGenerated + " and no_orden= :orden";
	    	parametros.put("orden", preLotInfo.getOrder());
	    	
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
}
