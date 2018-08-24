package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.Sellers;

public class SellersResponse {
	
	private String message;
	private String code;
	private List<Sellers> sellerResults;
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
	public List<Sellers> getSellerResults() {
		return sellerResults;
	}
	public void setSellerResults(List<Sellers> sellerResults) {
		this.sellerResults = sellerResults;
	}
	
	

}
