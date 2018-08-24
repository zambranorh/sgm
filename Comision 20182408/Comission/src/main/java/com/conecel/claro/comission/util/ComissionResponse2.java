package com.conecel.claro.comission.util;

import java.util.List;

import com.conecel.claro.comission.domain.Comission2;
import com.conecel.claro.comission.domain.ComissionResult;

public class ComissionResponse2 {
	
	private String message;
	private String code;
	List<ComissionResult> comission;
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
	public List<ComissionResult> getComission() {
		return comission;
	}
	public void setComission(List<ComissionResult> comission) {
		this.comission = comission;
	}
	
	

}
