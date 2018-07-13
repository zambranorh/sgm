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
@Table(name = "rc_tipo_financieras")
public class RCTipoFinanciera {

	@Id
	private String idTipoFin;
	private String descripcion;
	
	
	public RCTipoFinanciera() {}
	
	@OneToMany(mappedBy = "idTipoFin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCFinanciera> rcFinancieras = new HashSet<>();

	
	public String getIdTipoFin() {
		return idTipoFin;
	}

	public void setIdTipoFin(String idTipoFin) {
		this.idTipoFin = idTipoFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<RCFinanciera> getRcFinancieras() {
		return rcFinancieras;
	}

	public void setRcFinancieras(Set<RCFinanciera> rcFinancieras) {
		this.rcFinancieras = rcFinancieras;
	}
	
}
