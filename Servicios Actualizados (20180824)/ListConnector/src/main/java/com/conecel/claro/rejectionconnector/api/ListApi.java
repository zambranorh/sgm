package com.conecel.claro.rejectionconnector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.service.IChannelService;
import com.conecel.claro.rejectionconnector.service.IOfficeService;
import com.conecel.claro.rejectionconnector.service.IPaymentTypeService;
import com.conecel.claro.rejectionconnector.service.IPenaltiesService;
import com.conecel.claro.rejectionconnector.service.IReasonService;
import com.conecel.claro.rejectionconnector.service.ISellerService;
import com.conecel.claro.rejectionconnector.util.ChannelResponse;
import com.conecel.claro.rejectionconnector.util.OfficesResponse;
import com.conecel.claro.rejectionconnector.util.PaymentTypeResponse;
import com.conecel.claro.rejectionconnector.util.PenaltiesResponse;
import com.conecel.claro.rejectionconnector.util.ReasonsResponse;
import com.conecel.claro.rejectionconnector.util.SellersResponse;

//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
public class ListApi {
	
	PaymentTypeResponse paymentTypeResponse;
	
	ChannelResponse channelResponse;

	ReasonsResponse reasonResponse;
	
	OfficesResponse officeResponse;
	
	PenaltiesResponse penaltiesResponse;
	
	SellersResponse sellerResponse;
	
	@Autowired
	IReasonService reasonService;
	
	@Autowired
	IOfficeService officeService;
	
	@Autowired
	IPenaltiesService penaltiesService;
	
	@Autowired
	ISellerService sellerService;
	
	@Autowired
	IPaymentTypeService paymentTypeService;
	
	@Autowired
	IChannelService channelService;
	
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
	
	@RequestMapping(value = "/GetPenalties", method = RequestMethod.POST)
	public PenaltiesResponse getPenalties() {
		
		penaltiesResponse = penaltiesService.getPenalties();			
		return penaltiesResponse;
	}
	
	@RequestMapping(value = "/GetSellers", method = RequestMethod.POST)
	public SellersResponse getSellers() {
		
		sellerResponse = sellerService.getSellers();	
		return sellerResponse;
	}
	
	@RequestMapping(value = "/GetPayments", method = RequestMethod.POST)
	public PaymentTypeResponse getPayments() {
		
		paymentTypeResponse = paymentTypeService.getPaymentsType();
		return paymentTypeResponse;
	}
	
	@RequestMapping(value = "/GetChannels", method = RequestMethod.POST)
	public ChannelResponse getChannels() {
		
		channelResponse = channelService.getChannels();
		return channelResponse;
	}
}
