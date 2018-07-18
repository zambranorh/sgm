package com.conecel.claro.salesconnector.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Cacheable(false)
public class SalesResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	private String id;
	@Column(name="NOORDEN")
	private String noOrden;
	@Column(name="DESCRIPCIONVENTA")
	private String descripcionVenta;
	@Column(name="FECHA_INGRESO")
	private String fechaIngreso;
	@Column(name="CODOFICINA")
	private String codOficina;
	private String oficina;
	private String vendedor;
	@Column(name="IDENTIFICACIONCLIENTE")
	private String identificacionCliente;
	private String cliente;
	@Column(name="DESCRIPCIONPRODUCTO")
	private String descripcionProducto;
	@Column(name="VALOR_PRODUCTO")
	private String valorProducto;
	@Column(name="FECHA_ACTIVACION")
	private String fechaActivacion;
	private String estado;
	@Column(name="FORMAPAGO")
	private String formaPago;
	@Column(name="INSTITUCIONFINANCIERA")
	private String institucionFinanciera;
	@Column(name="NOSOLICITUD")
	private String solicitud;
	private String cuenta;
	@Column(name="USUARIOREG")
	private String usuarioReg;
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


	
	
}
