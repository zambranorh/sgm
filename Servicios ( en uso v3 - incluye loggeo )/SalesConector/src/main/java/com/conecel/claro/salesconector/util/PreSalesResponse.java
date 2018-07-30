package com.conecel.claro.salesconector.util;

import java.util.List;

import com.conecel.claro.salesconnector.domain.SalesResult;

public class PreSalesResponse {
	private String message;
	private String code;
	List<SalesResult> salesResult;
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
	public List<SalesResult> getSalesResult() {
		return salesResult;
	}
	public void setSalesResult(List<SalesResult> salesResult) {
		this.salesResult = salesResult;
	}
	
	
}
