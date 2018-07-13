package regularizacion.userservice.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rc_oficinas")
public class RCOficina {
	
	@Id
	private String idOficina;
	
	private String descripcion;
	private String direccion;
	private String estado;
	
	
	public RCOficina() {}
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_pais")
	private RCPais idPais;

	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_zona")
	private RCZona idZona;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_provincia")
	private RCProvincia idProvincia;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_localidad")
	private RCLocalidad idLocalidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_canal")
	private RCCanal idCanal;
	
	
	@OneToMany(mappedBy = "idOficina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();
	
	

	public String getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public RCPais getIdPais() {
		return idPais;
	}

	public void setIdPais(RCPais idPais) {
		this.idPais = idPais;
	}

	public RCZona getIdZona() {
		return idZona;
	}

	public void setIdZona(RCZona idZona) {
		this.idZona = idZona;
	}

	public RCProvincia getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(RCProvincia idProvincia) {
		this.idProvincia = idProvincia;
	}

	public RCLocalidad getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(RCLocalidad idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public RCCanal getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(RCCanal idCanal) {
		this.idCanal = idCanal;
	}

	public Set<RCVenta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(Set<RCVenta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}
	
	
	

}
