package regularizacion.userservice.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rc_venta")
public class RCVenta {

	@Id
	private BigDecimal numeroOrden;
	private BigDecimal cantidad;
	private BigDecimal valorProducto;
	private BigDecimal valorPenalizacion;
	
	private String descripcion;
	private String estado;
	private String idUsuarioReg;
	
	private Date fechaIngreso;
	private Date fechaActivacion;
	private Date fechaRegularizacion;
	
	
	public RCVenta() {}
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCOficina idOficina;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCVendedor idVendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCCliente idCliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCProducto idProducto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCPenalizacion idPenalizacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCFinanciera idFinanciera;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private RCFormasPagos idFormasPagos;


	public BigDecimal getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(BigDecimal numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(BigDecimal valorProducto) {
		this.valorProducto = valorProducto;
	}

	public BigDecimal getValorPenalizacion() {
		return valorPenalizacion;
	}

	public void setValorPenalizacion(BigDecimal valorPenalizacion) {
		this.valorPenalizacion = valorPenalizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioReg() {
		return idUsuarioReg;
	}

	public void setIdUsuarioReg(String idUsuarioReg) {
		this.idUsuarioReg = idUsuarioReg;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public Date getFechaRegularizacion() {
		return fechaRegularizacion;
	}

	public void setFechaRegularizacion(Date fechaRegularizacion) {
		this.fechaRegularizacion = fechaRegularizacion;
	}

	public RCOficina getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(RCOficina idOficina) {
		this.idOficina = idOficina;
	}

	public RCVendedor getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(RCVendedor idVendedor) {
		this.idVendedor = idVendedor;
	}

	public RCCliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(RCCliente idCliente) {
		this.idCliente = idCliente;
	}

	public RCProducto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(RCProducto idProducto) {
		this.idProducto = idProducto;
	}

	public RCPenalizacion getIdPenalizacion() {
		return idPenalizacion;
	}

	public void setIdPenalizacion(RCPenalizacion idPenalizacion) {
		this.idPenalizacion = idPenalizacion;
	}

	public RCFinanciera getIdFinanciera() {
		return idFinanciera;
	}

	public void setIdFinanciera(RCFinanciera idFinanciera) {
		this.idFinanciera = idFinanciera;
	}

	public RCFormasPagos getIdFormasPagos() {
		return idFormasPagos;
	}

	public void setIdFormasPagos(RCFormasPagos idFormasPagos) {
		this.idFormasPagos = idFormasPagos;
	}
	
	
}
