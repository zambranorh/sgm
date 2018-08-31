package com.conecel.claro.lotconector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.conecel.claro.lotconector.util.EntityCache;
import com.conecel.claro.lotconnector.dao.ILotResultDAO;
import com.conecel.claro.lotconnector.dto.Lot;
import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

import om.conecel.claro.lotconector.infraestructure.Notify;


@Service
public class LotResultService implements ILotResultService{
	
	@Autowired
	ILotResultDAO lotResultDAO;
	
	
	@Autowired
	RestTemplate restTempalte;
	
	@Autowired 
	NotificationInfoService notificationInfoService;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	protected HashOperations getHashOperations() {
		 
		return redisTemplate.opsForHash();
	}
	
	
	@Override
	public List<LotResult> obtieneRegulrizaciones(PreLotInfo preLotInfo){
		
		Notify notify = new Notify (restTempalte);
		
		List<LotResult> resultado= null;
		
		try {
			
			resultado=  lotResultDAO.obtieneRegulrizaciones(preLotInfo);
			
			/*EntityCache<LotResult> entityCache = new EntityCache<LotResult>();	
			entityCache.setResults(resultado);
			//setCacheData(key,entityCache);	
			
			getHashOperations().put("LoteCache", "1", entityCache );
			
		
			
			if( getHashOperations().hasKey("LoteCache","1")){
			
				
				entityCache = (EntityCache<LotResult>) getHashOperations().get("LoteCache","1");
				
				List<LotResult> x = entityCache.getResults();
				
				for (LotResult y: x) {
					System.out.println(y.getBanco());
				}
				
			} */
			
		}catch(Exception e) {
			e.printStackTrace();
			return resultado;
		}
		
		//notify.enviaNotificacion(notificationInfoService.getUrlNotify(), notificationInfoService.getRecipient(), notificationInfoService.getSender(), preLotInfo.getLotId(), resultado);
		
		return resultado;
		
		
	}

	@Override
	public String creaLote(Lot lote) {
		
		Notify notify = new Notify (restTempalte);
		
		String resultado = null;
		
		try {
		
			resultado=  lotResultDAO.creaLote(lote);
		
		}catch(Exception e) {
			e.printStackTrace();
			return resultado;
		}
		
		//notify.enviaNotificacion(notificationInfoService.getUrlNotify(), notificationInfoService.getRecipient(), notificationInfoService.getSender(), lote.getId().getLotId());
		
		return resultado;
	}

	@Override
	public Boolean actualizaLote(Lot lote) {
		
		Notify notify = new Notify (restTempalte);
		
		Boolean resultado = false;
		
		try
		{
		
		resultado= lotResultDAO.actualizaLote(lote);
		
		}catch(Exception e) {
			e.printStackTrace();
			return resultado;
		}
		
		//notify.enviaNotificacion(notificationInfoService.getUrlNotify(), notificationInfoService.getRecipient(), notificationInfoService.getSender(), lote.getId().getLotId());
		
		return resultado;
	}
	
	@Override
	public String obtieneSecuencia() {
		return lotResultDAO.obtieneSecuencia();
				
	}


}
