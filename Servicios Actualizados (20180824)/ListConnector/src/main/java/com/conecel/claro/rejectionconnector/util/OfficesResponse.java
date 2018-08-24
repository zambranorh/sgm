package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.Offices;

public class OfficesResponse {
	
	private String message;
	private String code;
	private List<Offices> officeResults;
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
	public List<Offices> getOfficeResults() {
		return officeResults;
	}
	public void setOfficeResults(List<Offices> officeResults) {
		this.officeResults = officeResults;
	}
	
	

}
