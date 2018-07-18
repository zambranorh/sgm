package com.conecel.claro.salesconector.util;

public class PreSalesResponse {
	private String message;
	private String code;
	private SalesResponse result;
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
	public SalesResponse getResult() {
		return result;
	}
	public void setResult(SalesResponse result) {
		this.result = result;
	}
}
