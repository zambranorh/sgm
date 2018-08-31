package com.conecel.claro.lotconector.util;

import java.util.List;

import com.conecel.claro.lotconnector.dto.LotResult;

public class PreLotResponses {
	
	private String message;
	private String code;
	private String lotId;
	private String lotDate;
	private int records;
	
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
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	public String getLotDate() {
		return lotDate;
	}
	public void setLotDate(String lotDate) {
		this.lotDate = lotDate;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
 
	

}
