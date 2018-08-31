package com.conecel.claro.lotconnector.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="rc_aud_operaciones", schema="regularizacion")
public class Audit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SEQ_RC_AUDIT")
    @SequenceGenerator(name = "SEQ_RC_AUDIT",sequenceName = "SEQ_RC_AUDIT",allocationSize = 1,initialValue = 1)
    @Column(name = "ID_AUDITORIA")
	private BigDecimal id_audit;
	private String so_user;
	private String machine;
	private String action;
	private String ip_address;
	
	public Audit() {}

	public BigDecimal getId_audit() {
		return id_audit;
	}

	public void setId_audit(BigDecimal id_audit) {
		this.id_audit = id_audit;
	}

	public String getSo_user() {
		return so_user;
	}

	public void setSo_user(String so_user) {
		this.so_user = so_user;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public Audit(BigDecimal id_audit, String so_user, String machine, String action, String ip_address) {
		super();
		this.id_audit = id_audit;
		this.so_user = so_user;
		this.machine = machine;
		this.action = action;
		this.ip_address = ip_address;
	}

	@Override
	public String toString() {
		return "Audit [id_audit=" + id_audit + ", so_user=" + so_user + ", machine=" + machine + ", action=" + action
				+ ", ip_address=" + ip_address + "]";
	}


	

}
