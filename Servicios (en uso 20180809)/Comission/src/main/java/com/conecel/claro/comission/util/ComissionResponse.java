package com.conecel.claro.comission.util;

import java.util.List;

import com.conecel.claro.comission.domain.Comission;



public class ComissionResponse {
	private String message;
	private String code;
	List<Comission> comission;
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
	public List<Comission> getComission() {
		return comission;
	}
	public void setComission(List<Comission> comission) {
		this.comission = comission;
	}
	
	
	
}
