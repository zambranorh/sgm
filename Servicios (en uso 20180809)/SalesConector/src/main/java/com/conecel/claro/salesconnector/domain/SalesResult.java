package com.conecel.claro.salesconnector.domain;

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
@JsonPropertyOrder({ "order", "description", "loggedDate", "officceId", "officce", "seller", "customerId", "customer", "product", "productValue", "activationDate", "status", "paymentType", "financialInstitution", "requestId", "account", "regularizedUser" })
public class SalesResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@JsonIgnore
	private String id;
	@JsonProperty("order")
	@Column(name="NOORDEN")
	private String noOrden;
	@JsonProperty("description")
	@Column(name="DESCRIPCIONVENTA")
	private String descripcionVenta;
	@JsonProperty("loggedDate")
	@Column(name="FECHA_INGRESO")
	private String fechaIngreso;
	@JsonProperty("officceId")
	@Column(name="CODOFICINA")
	private String codOficina;
	@JsonProperty("officce")
	@Column(name="OFICINA")
	private String oficina;
	@JsonProperty("seller")
	@Column(name="VENDEDOR") 
	private String vendedor;
	@JsonProperty("customerId")
	@Column(name="IDENTIFICACIONCLIENTE")
	private String identificacionCliente;
	@JsonProperty("customer")
	@Column(name="CLIENTE")
	private String cliente;
	@JsonProperty("product")
	@Column(name="DESCRIPCIONPRODUCTO")
	private String descripcionProducto;
	@JsonProperty("productValue")
	@Column(name="VALOR_PRODUCTO")
	private String valorProducto;
	@JsonProperty("activationDate")
	@Column(name="FECHA_ACTIVACION")
	private String fechaActivacion;
	@JsonProperty("status")
	@Column(name="ESTADO")
	private String estado;
	@JsonProperty("paymentType")
	@Column(name="FORMAPAGO")
	private String formaPago;
	@JsonProperty("financialInstitution")
	@Column(name="INSTITUCIONFINANCIERA")
	private String institucionFinanciera;
	@JsonProperty("requestId")
	@Column(name="NOSOLICITUD")
	private String solicitud;
	@JsonProperty("account")
	@Column(name="CUENTA")
	private String cuenta;
	@JsonProperty("regularizedUser")
	@Column(name="USUARIOREG")
	private String usuarioReg;
	@JsonProperty("lotId")
	@Column(name="LOTE")
	private String idLote;

	public SalesResult() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcionVenta() {
		return descripcionVenta;
	}

	public void setDescripcionVenta(String descripcionVenta) {
		this.descripcionVenta = descripcionVenta;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(String valorProducto) {
		this.valorProducto = valorProducto;
	}

	public String getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(String fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getInstitucionFinanciera() {
		return institucionFinanciera;
	}

	public void setInstitucionFinanciera(String institucionFinanciera) {
		this.institucionFinanciera = institucionFinanciera;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCodOficina() {
		return codOficina;
	}

	public void setCodOficina(String codOficina) {
		this.codOficina = codOficina;
	}

	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public String getUsuarioReg() {
		return usuarioReg;
	}

	public void setUsuarioReg(String usuarioReg) {
		this.usuarioReg = usuarioReg;
	}

	public String getNoOrden() {
		return noOrden;
	}

	public void setNoOrden(String noOrden) {
		this.noOrden = noOrden;
	}

	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}


	
	
}
