package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.Penalties;

public class PenaltiesResponse {
	
	private String message;
	private String code;
	private List<Penalties> penaltiesResults;
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
	public List<Penalties> getPenaltiesResults() {
		return penaltiesResults;
	}
	public void setPenaltiesResults(List<Penalties> penaltiesResults) {
		this.penaltiesResults = penaltiesResults;
	}
	
	

}
