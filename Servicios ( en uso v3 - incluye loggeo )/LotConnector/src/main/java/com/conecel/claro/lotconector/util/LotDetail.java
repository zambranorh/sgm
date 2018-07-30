package com.conecel.claro.lotconector.util;

import java.util.Date;

public class LotDetail {

	private String orderId;
	private String product;
	private String customer;
	private String customerId;
	private Date activationDate;
	private String loggedUser;
	private String paymentType;
	private String financialInstitution;
	private String officceId;
	private String officce;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public String getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
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
	public String getOfficceId() {
		return officceId;
	}
	public void setOfficceId(String officceId) {
		this.officceId = officceId;
	}
	public String getOfficce() {
		return officce;
	}
	public void setOfficce(String officce) {
		this.officce = officce;
	}
	
	
}
