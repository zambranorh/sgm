package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="rc_oficinas", schema="regularizacion")
public class Offices implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_OFICINA")
	private String officeId;
	@Column(name="DESCRIPCION")
	private String officeName;
	
	public Offices() {}
	
	
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}


	public Offices(String officeId, String officeName) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
	}


	@Override
	public String toString() {
		return "Offices [officeId=" + officeId + ", officeName=" + officeName + "]";
	}
	
	
	
	
}
