package com.conecel.claro.loginconector.util;

import java.util.List;

import com.conecel.claro.loginconnector.domain.LoginResult;

public class PreLoginResponse {
	
	private String message;
	private String code;
	private String token;
	private List<LoginResult> loginResult;
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
	public List<LoginResult> getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(List<LoginResult> loginResult) {
		this.loginResult = loginResult;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	
}
