package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.PaymentType;

public class PaymentTypeResponse {
	
	private String message;
	private String code;
	List<PaymentType> paymentResult;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<PaymentType> getPaymentResult() {
		return paymentResult;
	}
	public void setPaymentResult(List<PaymentType> paymentResult) {
		this.paymentResult = paymentResult;
	}
	
	

}
