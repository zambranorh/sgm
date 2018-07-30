package com.conecel.claro.comission.dto;

import java.io.Serializable;

public class ComissionPeriod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String startDate;
	private String endDate;
	
	public ComissionPeriod() {}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ComissionPeriod(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ComissionPeriod [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

}
