package com.conecel.claro.comissionconnector.domain;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Cacheable(false)
public class ComissionResult implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private String id;
	
	private String nombre;
	@Column(name="ID_CANAL")
	private String idCanal;
	@Column(name="ID_LOCALIDAD")
	private String idLocalidad;
	
	
	public ComissionResult() {}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getIdCanal() {
		return idCanal;
	}


	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}


	public String getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	 

}
