package com.conecel.claro.lotconnector.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rc_lotes2", schema="regularizacion")
public class Lot implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="NUMERO_LOTE")
	private String lotId;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_LOTE",length=7)
	private Date lotDate;
	@Id
	@Column(name="NO_ORDEN") 
	private String orderId;
	@Column(name="PRODUCTO")
	private String product;
	@Column(name="CLIENTE")
	private String customer;
	@Column(name="ID_CLIENTE")
	private String customerId;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ACTIVACION",length=7)
	private Date activationDate;
	@Column(name="USUARIO_INGRESO")
	private String loggedUser;
	@Column(name="FORMA_PAGO")
	private String paymentType;
	@Column(name="FINANCIERA")
	private String financialInstitution;
	@Column(name="ID_OFICINA")
	private String officceId;
	@Column(name="OFICINA")
	private String officce;
	@Column(name="DIAS")
	private String days;
	@Column(name="MOTIVO")
	private String reason;
	@Column(name="OBSERVACION")
	private String observation;
	@Column(name="ESTADO")
	private String status;
	@Column(name="USUARIO_REG")
	private String regularized_user;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_REG")
	private Date regularizedDate;
	
	
	
	public Date getRegularizedDate() {
		return regularizedDate;
	}

	public void setRegularizedDate(Date regularizedDate) {
		this.regularizedDate = regularizedDate;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegularized_user() {
		return regularized_user;
	}

	public void setRegularized_user(String regularized_user) {
		this.regularized_user = regularized_user;
	}

	public Lot() {}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public Date getLotDate() {
		return lotDate;
	}

	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
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

	public Lot(String lotId, Date lotDate, String orderId, String product, String customer, String customerId,
			Date activationDate, String loggedUser, String paymentType, String financialInstitution, String officceId,
			String officce, String days, String reason, String observation, String status, String regularized_user,
			Date regularizedDate) {
		super();
		this.lotId = lotId;
		this.lotDate = lotDate;
		this.orderId = orderId;
		this.product = product;
		this.customer = customer;
		this.customerId = customerId;
		this.activationDate = activationDate;
		this.loggedUser = loggedUser;
		this.paymentType = paymentType;
		this.financialInstitution = financialInstitution;
		this.officceId = officceId;
		this.officce = officce;
		this.days = days;
		this.reason = reason;
		this.observation = observation;
		this.status = status;
		this.regularized_user = regularized_user;
		this.regularizedDate = regularizedDate;
	}

	@Override
	public String toString() {
		return "Lot [lotId=" + lotId + ", lotDate=" + lotDate + ", orderId=" + orderId + ", product=" + product
				+ ", customer=" + customer + ", customerId=" + customerId + ", activationDate=" + activationDate
				+ ", loggedUser=" + loggedUser + ", paymentType=" + paymentType + ", financialInstitution="
				+ financialInstitution + ", officceId=" + officceId + ", officce=" + officce + ", days=" + days
				+ ", reason=" + reason + ", observation=" + observation + ", status=" + status + ", regularized_user="
				+ regularized_user + ", regularizedDate=" + regularizedDate + "]";
	}

	

	
	
	
}
