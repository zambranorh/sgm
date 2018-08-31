package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.PaymentType;
import com.conecel.claro.rejectionconnector.util.PaymentTypeResponse;
@Service
public class PaymentTypeService implements IPaymentTypeService{
	
	PaymentTypeResponse paymentTypeResponse;
	
	@Autowired
	IPaymentTypeServiceDAO paymentTypeService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public PaymentTypeResponse getPaymentsType() {
		
		paymentTypeResponse = new PaymentTypeResponse();
		
		try {
			List<PaymentType> paymentsType =paymentTypeService.getPaymentsType();
			paymentTypeResponse.setPaymentResult(paymentsType);
			
			if(paymentsType.isEmpty()) {
				paymentTypeResponse.setCode("-1");
				paymentTypeResponse.setMessage("");
			}
			
			paymentTypeResponse.setCode("200");
			paymentTypeResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de formas de pago: ", e);
		}
		return paymentTypeResponse;
	}

}
