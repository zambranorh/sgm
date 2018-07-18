package com.conecel.claro.salesconnector.dto;

import java.io.Serializable;

public class PreSalesInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String orden; 
	
	public PreSalesInfo() {}

	public PreSalesInfo(String orden) {
		super();
		this.orden = orden;
	}

	public String getorden() {
		return orden;
	}

	public void setorden(String orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "PreSalesInfo [orden=" + orden + "]";
	}
	
	

}
