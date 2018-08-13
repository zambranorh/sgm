package com.conecel.claro.loginconnector.dto;

import java.io.Serializable;

public class PreLoginInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	
	public PreLoginInfo() {}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PreLoginInfo(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	@Override
	public String toString() {
		return "PreLoginInfo [user=" + user + ", password=" + password + "]";
	}
	
	

}
