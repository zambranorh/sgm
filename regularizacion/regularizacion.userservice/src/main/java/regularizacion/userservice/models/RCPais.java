package regularizacion.userservice.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rc_paises")
public class RCPais {

	@Id
	private String idPais;
	private String descripcion;
	
	public RCPais() {}
	
	@OneToMany(mappedBy = "idPais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCOficina> rcOficinas = new HashSet<>();
	
/*	@OneToMany(mappedBy = "idPais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCZona> rcZonas = new HashSet<>();
	
	@OneToMany(mappedBy = "idPais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCProvincia> rcProvincias = new HashSet<>(); */

	
	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
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
	
	
	
}
