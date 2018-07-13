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
@Table(name = "rc_formas_pagos")
public class RCFormasPagos {
	
	@Id
	private String codigo;
	private String descripcion;
	
	public RCFormasPagos() {}
	
	
	@OneToMany(mappedBy = "idFormasPagos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RCVenta> listadoVentas = new HashSet<>();
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<RCVenta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(Set<RCVenta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}


}
