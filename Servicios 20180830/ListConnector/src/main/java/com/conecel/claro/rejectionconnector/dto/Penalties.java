package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rc_penalizaciones", schema="regularizacion")
public class Penalties implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PENALIZACION")
	private String penaltyId;
	@Column(name="DESCRIPCION")
	private String description;
	
	public Penalties() {}

	public String getPenaltyId() {
		return penaltyId;
	}

	public void setPenaltyId(String penaltyId) {
		this.penaltyId = penaltyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Penalties(String penaltyId, String description) {
		super();
		this.penaltyId = penaltyId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Penalties [penaltyId=" + penaltyId + ", description=" + description + "]";
	}
	
	

}
