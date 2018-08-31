package com.conecel.claro.lotconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LotId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(name="NUMERO_LOTE")
	private String lotId;
	@Column(name="NO_ORDEN") 
	private String orderId;
	
	public LotId() {}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LotId(String lotId, String orderId) {
		super();
		this.lotId = lotId;
		this.orderId = orderId;
	}
	
	
	

}
