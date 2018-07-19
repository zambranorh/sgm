package com.conecel.claro.lotconnector.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Cacheable(false)
@JsonPropertyOrder({ "customerId", "activationDate", "loggedUser", "paymentType", "financialInstitution", "officceId", "officce", "days", "status", "reason", "observation", "regularizedUser" })
public class LotResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@JsonIgnore
	private String id;	
	@JsonProperty("customerId")
	@Column(name="IDENTIDAD")
	private String identidad;
	@JsonProperty("activationDate")
	@Column(name="FECHA_ACTIVACION")
	private String fechaActivacion;
	@JsonProperty("loggedUser")
	@Column(name="USUARIO_INGRESO")
	private String usuarioIngreso;
	@JsonProperty("paymentType")
	@Column(name="FORMA_PAGO")
	private String formaPago;
	@JsonProperty("financialInstitution")
	@Column(name="BANCO")
	private String banco;
	@JsonProperty("officceId")
	@Column(name="ID_OFICINA")
	private String idOficina;
	@JsonProperty("officce")
	@Column(name="OFICINA")
	private String oficina;
	@JsonProperty("days")
	@Column(name="DIAS")
	private String dias;
	@JsonProperty("status")
	@Column(name="ESTADO")
	private String estado;
	@JsonProperty("reason")
	@Column(name="MOTIVO")
	private String motivo;
	@JsonProperty("observation")
	@Column(name="OBSERVACION")
	private String observacion;
	@JsonProperty("regularizedUser")
	@Column(name="USUARIO_REG")
	private String usuarioReg;
	
	public LotResult() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(String fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUsuarioReg() {
		return usuarioReg;
	}

	public void setUsuarioReg(String usuarioReg) {
		this.usuarioReg = usuarioReg;
	}
	
	
	

}
