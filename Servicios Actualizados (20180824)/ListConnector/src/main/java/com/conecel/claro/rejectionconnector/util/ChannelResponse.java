package com.conecel.claro.rejectionconnector.util;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.Channel;

public class ChannelResponse {
	
	private String message;
	private String code;
	private List<Channel> channelResults;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Channel> getChannelResults() {
		return channelResults;
	}
	public void setChannelResults(List<Channel> channelResults) {
		this.channelResults = channelResults;
	}
	
	

}
