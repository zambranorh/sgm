package regularizacion.userservice.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rc_penalizaciones")
public class RCPenalizacion {
	
	@Id
	private BigDecimal idPenalizacion;
	private String descripcion;
	private BigDecimal porcentaje;
	private Date fechaCreacion;
	private Date fechaActualiza;
	private String observacion;
	private BigDecimal valor;
	private String estado;
	
	
	public RCPenalizacion() {}
	
	
	@OneToMany(mappedBy = "idPenalizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();
	
	public BigDecimal getIdPenalizacion() {
		return idPenalizacion;
	}
	
	public void setIdPenalizacion(BigDecimal idPenalizacion) {
		this.idPenalizacion = idPenalizacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Date getFechaActualiza() {
		return fechaActualiza;
	}
	
	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	
	public String getObservacion() {
		return observacion;
	}
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<RCVenta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(Set<RCVenta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}
	

	
}
