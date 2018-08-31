package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.PaymentType;

public interface IPaymentTypeDAO {
	
	List<PaymentType> obtieneFormasPago();

}
