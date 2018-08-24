package com.conecel.claro.rejectionconnector.dto;

import java.io.Serializable;

public class ChannelInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String channelId;
	
	public ChannelInfo() {}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public ChannelInfo(String channelId) {
		super();
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "ChannelInfo [channelId=" + channelId + "]";
	}
	
	

}
