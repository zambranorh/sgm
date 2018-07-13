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
@Table(name="rc_localidades")
public class RCLocalidad {

	@Id
	private String idLocalidad;
	private String descripcion;
	
	public RCLocalidad() {}
	
	@OneToMany(mappedBy = "idLocalidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCOficina> rcOficinas = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_provincia")
	private RCProvincia idProvincia;

	public String getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Set<RCOficina> getRcOficinas() {
		return rcOficinas;
	}


	public void setRcOficinas(Set<RCOficina> rcOficinas) {
		this.rcOficinas = rcOficinas;
	}


	public RCProvincia getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(RCProvincia idProvincia) {
		this.idProvincia = idProvincia;
	}
	
	
}
