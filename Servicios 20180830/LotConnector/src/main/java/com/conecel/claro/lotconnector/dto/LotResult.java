package com.conecel.claro.lotconnector.dto;

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
@JsonPropertyOrder({ "orderId", "customer", "customerId", "activationDate", "loggedUser", "paymentType", "financialInstitution", "officceId", "officce", "days", "status", "reason", "observation", "regularizedUser", "regDate" })
public class LotResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@JsonProperty("orderId")
	@Column(name="NO_ORDEN")
	private String orderId;
	@JsonProperty("customer")
	@Column(name="CLIENTE")
	private String customer;
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
	@JsonProperty("lotId")
	@Column(name="NUMERO_LOTE")
	private String numeroLote;
	@JsonProperty("lotDate")
	@Column(name="FECHA_LOTE")
	private String fechaLote;
	@JsonProperty("regDate")
	@Column(name="FECHA_REG")
	private String fechaReg;

	
	public LotResult() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
		return (dias==null)?"":dias;
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
		return (motivo==null)?"":motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacion() {
		return (observacion==null)?"":observacion;
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

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public String getFechaLote() {
		return fechaLote;
	}

	public void setFechaLote(String fechaLote) {
		this.fechaLote = fechaLote;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

	
	
	

}
