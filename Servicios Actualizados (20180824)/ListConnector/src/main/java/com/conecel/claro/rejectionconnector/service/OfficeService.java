package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.dto.Offices;
import com.conecel.claro.rejectionconnector.util.OfficesResponse;

@Service
public class OfficeService implements IOfficeService{
	
	OfficesResponse officesResponse;
	
	@Autowired
	IOfficeServiceDAO officeService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public OfficesResponse getOffices(ChannelInfo channelInfo) {
		
		officesResponse = new OfficesResponse();
		
		try {
			
			List<Offices> offices= officeService.getOffices(channelInfo);
			officesResponse.setOfficeResults(offices);
			
			if (offices.isEmpty()) {
				
				officesResponse.setCode("-1");
				officesResponse.setMessage("");
			}
			
			officesResponse.setCode("200");
			officesResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de oficinas: ", e);
		}
		return officesResponse;
	}

}
