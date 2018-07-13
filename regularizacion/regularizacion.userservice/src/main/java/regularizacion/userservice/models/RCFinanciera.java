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
@Table(name = "rc_financieras")
public class RCFinanciera {

	@Id
	private String idFinanciera;
	private String descripcion;
	private String estado;
	
	public RCFinanciera() {}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "id_tipo_fin")
	private RCTipoFinanciera idTipoFin;
	
	
	@OneToMany(mappedBy = "idFinanciera", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();

	
	public String getIdFinanciera() {
		return idFinanciera;
	}

	public void setIdFinanciera(String idFinanciera) {
		this.idFinanciera = idFinanciera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public RCTipoFinanciera getIdTipoFin() {
		return idTipoFin;
	}

	public void setIdTipoFin(RCTipoFinanciera idTipoFin) {
		this.idTipoFin = idTipoFin;
	}

	public Set<RCVenta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(Set<RCVenta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}
	

	
}
