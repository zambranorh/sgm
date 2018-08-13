package com.conecel.claro.loginconnector.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@Entity
@Cacheable(false)
@JsonPropertyOrder({ "userId", "userName", "nickName", "password", "idRole", "roleName" })
public class LoginResult {
	
	@Id
	@NotNull
	@JsonIgnore
	private String id;	
	
	@JsonProperty("userId")
	@Column(name="USERID")
	private String userId;
	
	@JsonProperty("userName")
	@Column(name="USERDESCRIPTION")
	private String userName;
	
	
	@JsonProperty("nickName")
	@Column(name="USERNAME")
	private String nickName;
	
	
	@JsonProperty("password")
	@Column(name="PASSWORD")
	private String password;
	
	
	@JsonProperty("idRole")
	@Column(name="ID_ROL")
	private String idRole;
	
	@JsonProperty("roleName")
	@Column(name="ROLENAME")
	private String roleName;
	

}
