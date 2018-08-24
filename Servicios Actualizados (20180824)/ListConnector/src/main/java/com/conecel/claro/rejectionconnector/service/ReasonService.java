package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Reasons;
import com.conecel.claro.rejectionconnector.util.ReasonsResponse;
@Service
public class ReasonService implements IReasonService{

	ReasonsResponse reasonsResponse;
	
	@Autowired
	IReasonServiceDAO reasonService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ReasonsResponse getReasons() {
		
		reasonsResponse = new ReasonsResponse();
		
		try {
			List<Reasons> reasons = reasonService.obtieneMotivos();
			reasonsResponse.setReasonsResults(reasons);
			
			if(reasons.isEmpty()) {
				reasonsResponse.setCode("-1");
				reasonsResponse.setMessage("");
			}
			
			reasonsResponse.setCode("200");
			reasonsResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de motivos: ", e);
		}
		return reasonsResponse;
	}

}
