package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rc_vendedor", schema="regularizacion")
public class Sellers implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_VENDEDOR")
	private String sellerId;
	@Column(name="NOMBRE")
	private String sellerName;
	
	public Sellers() {}

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

	public Sellers(String sellerId, String sellerName) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
	}

	@Override
	public String toString() {
		return "Sellers [sellerId=" + sellerId + ", sellerName=" + sellerName + "]";
	}
	
	

}
