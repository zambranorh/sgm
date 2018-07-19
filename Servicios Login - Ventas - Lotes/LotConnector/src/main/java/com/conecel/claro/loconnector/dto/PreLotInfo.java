package com.conecel.claro.loconnector.dto;

import java.io.Serializable;

public class PreLotInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String startDate;
	private String endDate;
	private String order;
	private String customerId;
	private String salesChannel;
	private String paymentType;
	private String financialInstitution;
	
	
	
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



	public String getOrder() {
		return order;
	}



	public void setOrder(String order) {
		this.order = order;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getSalesChannel() {
		return salesChannel;
	}



	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}



	public String getPaymentType() {
		return paymentType;
	}



	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}



	public String getFinancialInstitution() {
		return financialInstitution;
	}



	public void setFinancialInstitution(String financialInstitution) {
		this.financialInstitution = financialInstitution;
	}



	public PreLotInfo(String startDate, String endDate, String order, String customerId, String salesChannel,
			String paymentType, String financialInstitution) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.order = order;
		this.customerId = customerId;
		this.salesChannel = salesChannel;
		this.paymentType = paymentType;
		this.financialInstitution = financialInstitution;
	}



	@Override
	public String toString() {
		return "PreLotInfo [startDate=" + startDate + ", endDate=" + endDate + ", order=" + order + ", customerId="
				+ customerId + ", salesChannel=" + salesChannel + ", paymentType=" + paymentType
				+ ", financialInstitution=" + financialInstitution + "]";
	}



	public PreLotInfo() {}

}
