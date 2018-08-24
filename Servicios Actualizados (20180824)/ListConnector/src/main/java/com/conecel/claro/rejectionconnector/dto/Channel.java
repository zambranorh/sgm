package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rc_oficinas", schema="regularizacion")
public class Channel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CANAL")
	private String channelId;
	@Column(name="DESCRIPCION")
	private String description;
	
	public Channel() {}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Channel(String channelId, String description) {
		super();
		this.channelId = channelId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", description=" + description + "]";
	}
	
	

}
