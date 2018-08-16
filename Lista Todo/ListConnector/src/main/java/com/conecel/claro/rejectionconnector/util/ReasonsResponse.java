package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.Reasons;

public class ReasonsResponse {
	private String message;
	private String code;
	private List<Reasons> reasonsResults;
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
	public List<Reasons> getReasonsResults() {
		return reasonsResults;
	}
	public void setReasonsResults(List<Reasons> reasonsResults) {
		this.reasonsResults = reasonsResults;
	}
	
	
}
