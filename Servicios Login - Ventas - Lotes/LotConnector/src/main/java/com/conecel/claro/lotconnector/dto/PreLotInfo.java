package com.conecel.claro.lotconnector.dto;

import java.io.Serializable;

public class PreLotInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String startDate;
	private String endDate;
	private String orderId;
	private String customerId;
	private String salesChannel;
	private String paymentType;
	private String financialInstitution;
	
	public PreLotInfo(){}

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public PreLotInfo(String startDate, String endDate, String orderId, String customerId, String salesChannel,
			String paymentType, String financialInstitution) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderId = orderId;
		this.customerId = customerId;
		this.salesChannel = salesChannel;
		this.paymentType = paymentType;
		this.financialInstitution = financialInstitution;
	}

	@Override
	public String toString() {
		return "PreLotInfo [startDate=" + startDate + ", endDate=" + endDate + ", orderId=" + orderId + ", customerId="
				+ customerId + ", salesChannel=" + salesChannel + ", paymentType=" + paymentType
				+ ", financialInstitution=" + financialInstitution + "]";
	}
	
	
	

}
