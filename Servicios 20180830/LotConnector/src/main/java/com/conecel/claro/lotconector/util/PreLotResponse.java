package com.conecel.claro.lotconector.util;

import java.util.List;

import com.conecel.claro.lotconnector.dto.LotResult;

public class PreLotResponse {
	
	private String message;
	private String code;
	
	private List<LotResult> lotResults;
	
 	
	
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
	public List<LotResult> getLotResults() {
		return lotResults;
	}
	public void setLotResults(List<LotResult> lotResults) {
		this.lotResults = lotResults;
	}
 
	

}
