package com.conecel.claro.comission.dto;

import java.io.Serializable;

public class ComissionInputs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String requestId; 
	private String sellerId;
	private String channelId;
	private String locationId;
	
	public ComissionInputs() {}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public ComissionInputs(String requestId, String sellerId, String channelId, String locationId) {
		super();
		this.requestId = requestId;
		this.sellerId = sellerId;
		this.channelId = channelId;
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "ComissionInputs [requestId=" + requestId + ", sellerId=" + sellerId + ", channelId=" + channelId
				+ ", locationId=" + locationId + "]";
	}
	
	
}
