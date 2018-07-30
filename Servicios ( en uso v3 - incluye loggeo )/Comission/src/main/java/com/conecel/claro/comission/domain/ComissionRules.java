package com.conecel.claro.comission.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
@Cacheable(false)
public class ComissionRules implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name="ID_DETALLE")
	private String penaltyId;
	@Column(name="TI")
	private float startDay;
	@Column(name="TF")
	private float endDay;
	@Column(name="VALOR")
	private float value;
	
	public ComissionRules() {}

	public String getPenaltyId() {
		return penaltyId;
	}

	public void setPenaltyId(String penaltyId) {
		this.penaltyId = penaltyId;
	}

	public float getStartDay() {
		return startDay;
	}

	public void setStartDay(float startDay) {
		this.startDay = startDay;
	}

	public float getEndDay() {
		return endDay;
	}

	public void setEndDay(float endDay) {
		this.endDay = endDay;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	
	

}
