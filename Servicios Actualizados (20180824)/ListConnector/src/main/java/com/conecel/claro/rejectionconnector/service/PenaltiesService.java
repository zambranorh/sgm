package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Penalties;
import com.conecel.claro.rejectionconnector.util.PenaltiesResponse;
@Service
public class PenaltiesService implements IPenaltiesService{
	
	@Autowired
	IPenaltiesServiceDAO penaltiesService;
	
	PenaltiesResponse penaltiesResponse;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public PenaltiesResponse getPenalties() {
		penaltiesResponse = new PenaltiesResponse();

		try {
			List<Penalties> penalties = penaltiesService.obtienePenalizaciones();
			penaltiesResponse.setPenaltiesResults(penalties);
			
			if(penalties.isEmpty()) {
				penaltiesResponse.setCode("-1");
				penaltiesResponse.setMessage("");
			}
			
			penaltiesResponse.setCode("200");
			penaltiesResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de penalizaciones: ", e);
		}
		return penaltiesResponse;
	}

}
