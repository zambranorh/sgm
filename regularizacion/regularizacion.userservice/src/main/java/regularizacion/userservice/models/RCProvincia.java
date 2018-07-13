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
@Table(name = "rc_provincias")
public class RCProvincia {
	
	@Id
	private String idProvincia;
	private String descripcion;
	
	
	public RCProvincia() {}
	
/*	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pais")
	private RCPais idPais;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_zona")
	private RCZona idZona; */
	

	@OneToMany(mappedBy = "idProvincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCOficina> rcOficinas = new HashSet<>();
	
/*	@OneToMany(mappedBy = "idProvincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCLocalidad> rcLocalidades = new HashSet<>();
*/
	
	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
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
