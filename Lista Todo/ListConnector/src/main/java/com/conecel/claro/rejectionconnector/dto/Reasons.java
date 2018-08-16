package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="rc_motivos_penalizacion", schema="regularizacion")
public class Reasons implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_MOTIVO")
	private String idReason;
	@Column(name="DESCRIPCION")
	private String description;
	
	public Reasons() {}

	public String getIdReason() {
		return idReason;
	}

	public void setIdReason(String idReason) {
		this.idReason = idReason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Reasons(String idReason, String description) {
		super();
		this.idReason = idReason;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Reasons [idReason=" + idReason + ", description=" + description + "]";
	}
	
	
	
}
