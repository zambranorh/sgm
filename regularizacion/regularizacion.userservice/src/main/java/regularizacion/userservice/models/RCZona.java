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
@Table(name = "rc_zonas")
public class RCZona {
	
	@Id
	private String idZona;
	private String descripcion;
	
	
	public RCZona() {}
	
	
	@OneToMany(mappedBy = "idZona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCOficina> rcOficinas = new HashSet<>();
	
/*	@OneToMany(mappedBy = "idZona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCProvincia> rcProvincias = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pais")
	private RCPais idPais; */

	
	
	public String getIdZona() {
		return idZona;
	}

	public void setIdZona(String idZona) {
		this.idZona = idZona;
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
