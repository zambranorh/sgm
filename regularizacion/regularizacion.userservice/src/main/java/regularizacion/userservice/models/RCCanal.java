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
@Table(name = "rc_canal")
public class RCCanal {

	@Id
	private String idCanal;
	private String descripcion;
	
	@OneToMany(mappedBy = "idCanal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCOficina> rcOficinas = new HashSet<>();
	
	public RCCanal() {}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
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
