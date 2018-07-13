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
@Table(name = "rc_producto")
public class RCProducto {
	
	@Id
	private String idProducto;
	private String descripcion;
	private BigDecimal costo;
	private Date fechaRegistro;
	private String estado;
	private Date fechaActualizacion;
	
	public RCProducto() {}

	
	@OneToMany(mappedBy = "idProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();
	
	
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Set<RCVenta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(Set<RCVenta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}
	

}
