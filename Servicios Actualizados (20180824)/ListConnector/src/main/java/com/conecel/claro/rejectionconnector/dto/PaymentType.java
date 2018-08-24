package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rc_formas_pagos", schema="regularizacion")
public class PaymentType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CODIGO")
	private String idPayment;
	@Column(name="DESCRIPCION")
	private String description;
	
	public PaymentType() {}

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PaymentType(String idPayment, String description) {
		super();
		this.idPayment = idPayment;
		this.description = description;
	}

	@Override
	public String toString() {
		return "PaymentType [idPayment=" + idPayment + ", description=" + description + "]";
	}
	
	
	

}
