package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.PaymentType;

public interface IPaymentTypeServiceDAO {
	
	List<PaymentType> getPaymentsType();

}
