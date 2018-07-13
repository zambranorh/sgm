package regularizacion.userservice.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rc_cliente")
public class RCCliente {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	private String idCliente;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;
	private String estado;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	
	
	public RCCliente() {}


	@OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();
	
	
	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
