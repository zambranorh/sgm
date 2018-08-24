package com.conecel.claro.comission.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rc_comisiones2", schema="regularizacion")
public class Comission2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="ID_SOLICITUD")
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
	@Column(name="SUB_COMISION")
	private float subComission;
	@Column(name="VALOR_PENALIZACION")
	private float penaltyValue;
	@Column(name="TOTAL_COMISION")
	private float comissionValue;
	@Column(name="MENSAJE")
	private String message;
	
	public Comission2 () {}

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

	public float getSubComission() {
		return subComission;
	}

	public void setSubComission(float subComission) {
		this.subComission = subComission;
	}

	public float getPenaltyValue() {
		return penaltyValue;
	}

	public void setPenaltyValue(float penaltyValue) {
		this.penaltyValue = penaltyValue;
	}

	public float getComissionValue() {
		return comissionValue;
	}

	public void setComissionValue(float comissionValue) {
		this.comissionValue = comissionValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Comission2(@NotNull String idOrder, String locationId, String channel, String sellerName, String sellerId,
			String customerName, String customerId, String plan, String account, Date registerDate,
			Date regularizationDate, String regularizationUser, String device, Integer quantity, Date activationDate,
			Date inconsistencyDate, String inconsistencyUser, String inconsistency, Integer deliveryDays,
			float subComission, float penaltyValue, float comissionValue, String message) {
		super();
		this.idOrder = idOrder;
		this.locationId = locationId;
		this.channel = channel;
		this.sellerName = sellerName;
		this.sellerId = sellerId;
		this.customerName = customerName;
		this.customerId = customerId;
		this.plan = plan;
		this.account = account;
		this.registerDate = registerDate;
		this.regularizationDate = regularizationDate;
		this.regularizationUser = regularizationUser;
		this.device = device;
		this.quantity = quantity;
		this.activationDate = activationDate;
		this.inconsistencyDate = inconsistencyDate;
		this.inconsistencyUser = inconsistencyUser;
		this.inconsistency = inconsistency;
		this.deliveryDays = deliveryDays;
		this.subComission = subComission;
		this.penaltyValue = penaltyValue;
		this.comissionValue = comissionValue;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Comission2 [idOrder=" + idOrder + ", locationId=" + locationId + ", channel=" + channel
				+ ", sellerName=" + sellerName + ", sellerId=" + sellerId + ", customerName=" + customerName
				+ ", customerId=" + customerId + ", plan=" + plan + ", account=" + account + ", registerDate="
				+ registerDate + ", regularizationDate=" + regularizationDate + ", regularizationUser="
				+ regularizationUser + ", device=" + device + ", quantity=" + quantity + ", activationDate="
				+ activationDate + ", inconsistencyDate=" + inconsistencyDate + ", inconsistencyUser="
				+ inconsistencyUser + ", inconsistency=" + inconsistency + ", deliveryDays=" + deliveryDays
				+ ", subComission=" + subComission + ", penaltyValue=" + penaltyValue + ", comissionValue="
				+ comissionValue + ", message=" + message + "]";
	}





	
	
	

	
	
	
	

}
