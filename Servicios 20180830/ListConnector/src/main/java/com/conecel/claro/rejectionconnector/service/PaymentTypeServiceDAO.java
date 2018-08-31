package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.IPaymentTypeDAO;
import com.conecel.claro.rejectionconnector.dto.PaymentType;

@Service
public class PaymentTypeServiceDAO implements IPaymentTypeServiceDAO{
	
	@Autowired
	IPaymentTypeDAO paymentTypeDAO;

	@Override
	public List<PaymentType> getPaymentsType() {
		
		return paymentTypeDAO.obtieneFormasPago();
	}

}
