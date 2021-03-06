package com.conecel.claro.comission.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Cacheable(false)
public class PreComission2 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="NUMERO_ORDEN")
	private String idOrder;
	@Column(name="ID_LOCALIDAD")
	private String locationId;
	@Column(name="ID_CANAL")
	private String channel;
	@Column(name="NOMBRE_VENDEDOR")
	private String sellerName;
	@Column(name="ID_VENDEDOR")
	private String sellerId;
	@Column(name="NOMBRE_CLIENTE")
	private String customerName;
	@Column(name="ID_CLIENTE")
	private String customerId;
	@Column(name="PLAN")
	private String plan;
	@Column(name="ID_CUENTA")
	private String account;
	@Column(name="FECHA_ING",length=7)
	private Date registerDate;
	@Column(name="FECHA_REG",length=7)
	private Date regularizationDate;
	@Column(name="USUARIO_REG")
	private String regularizationUser;
	@Column(name="EQUIPO")
	private String device;
	@Column(name="CANTIDAD")
	private Integer quantity;
	@Column(name="FECHA_ACT",length=7)
	private Date activationDate;
	@Column(name="FECHA_INC",length=7)
	private Date inconsistencyDate;
	@Column(name="USUARIO_INC")
	private String inconsistencyUser;
	@Column(name="MOTIVO")
	private String inconsistency;
	@Column(name="DIAS")
	private Integer deliveryDays;
	@Column(name="MENSAJE")
	private String message;
	
	public PreComission2() {}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getRegularizationDate() {
		return regularizationDate;
	}

	public void setRegularizationDate(Date regularizationDate) {
		this.regularizationDate = regularizationDate;
	}

	public String getRegularizationUser() {
		return regularizationUser;
	}

	public void setRegularizationUser(String regularizationUser) {
		this.regularizationUser = regularizationUser;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getInconsistencyDate() {
		return inconsistencyDate;
	}

	public void setInconsistencyDate(Date inconsistencyDate) {
		this.inconsistencyDate = inconsistencyDate;
	}

	public String getInconsistencyUser() {
		return inconsistencyUser;
	}

	public void setInconsistencyUser(String inconsistencyUser) {
		this.inconsistencyUser = inconsistencyUser;
	}

	public String getInconsistency() {
		return inconsistency;
	}

	public void setInconsistency(String inconsistency) {
		this.inconsistency = inconsistency;
	}

	public Integer getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	


}
