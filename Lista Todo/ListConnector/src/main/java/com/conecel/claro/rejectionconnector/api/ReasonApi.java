package com.conecel.claro.rejectionconnector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.service.IOfficeService;
import com.conecel.claro.rejectionconnector.service.IReasonService;
import com.conecel.claro.rejectionconnector.util.OfficesResponse;
import com.conecel.claro.rejectionconnector.util.ReasonsResponse;

//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
public class ReasonApi {

	ReasonsResponse reasonResponse;
	
	OfficesResponse officeResponse;
	
	@Autowired
	IReasonService reasonService;
	
	@Autowired
	IOfficeService officeService;
	
	@RequestMapping(value = "/GetReasons", method = RequestMethod.POST)
	public ReasonsResponse getReasons() {
		
		reasonResponse = reasonService.getReasons();
			
		return reasonResponse;
	}
	
	@RequestMapping(value = "/GetOffices", method = RequestMethod.POST)
	public OfficesResponse getOffices(@RequestBody ChannelInfo channelInfo) {
		
		officeResponse = officeService.getOffices(channelInfo);
			
		return officeResponse;
	}
	
}
