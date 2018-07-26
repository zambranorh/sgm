package com.conecel.claro.comission.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="rc_comisiones", schema="regularizacion")
public class Comission implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="ID_SOLICITUD")
	private String idOrder;
	@Column(name="ID_CUENTA")
	private String account;
	@Column(name="ID_VENDEDOR")
	private String sellerId;
	@Column(name="NOMBRE_VENDEDOR")
	private String sellerName;
	@Column(name="ID_CANAL")
	private String channel;
	@Column(name="ID_LOCALIDAD")
	private String locationId;
	@Column(name="DIAS")
	private float deliveryDays;
	@Column(name="SUB_COMISION")
	private float subComission;
	@Column(name="VALOR_PENALIZACION")
	private float penaltyValue;
	@Column(name="TOTAL_COMISION")
	private float comissionValue;
	
	public Comission () {}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public float getDeliveryDays() {
		return deliveryDays;
	}

	public void setDeliveryDays(float deliveryDays) {
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

	public Comission(@NotNull String idOrder, String account, String sellerId, String sellerName, String channel,
			String locationId, float deliveryDays, float subComission, float penaltyValue, float comissionValue) {
		super();
		this.idOrder = idOrder;
		this.account = account;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.channel = channel;
		this.locationId = locationId;
		this.deliveryDays = deliveryDays;
		this.subComission = subComission;
		this.penaltyValue = penaltyValue;
		this.comissionValue = comissionValue;
	}

	@Override
	public String toString() {
		return "Comission [idOrder=" + idOrder + ", account=" + account + ", sellerId=" + sellerId + ", sellerName="
				+ sellerName + ", channel=" + channel + ", locationId=" + locationId + ", deliveryDays=" + deliveryDays
				+ ", subComission=" + subComission + ", penaltyValue=" + penaltyValue + ", comissionValue="
				+ comissionValue + "]";
	}

	

}
