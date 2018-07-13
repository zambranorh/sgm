package com.conecel.claro.comissionconector.dto.entities;

public class PenaltyInfo {
	private String penaltyId;
	private Integer term;
	private Double percentage;
	
	public String getPenaltyId() {
		return penaltyId;
	}
	public void setPenaltyId(String penaltyId) {
		this.penaltyId = penaltyId;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	
}
