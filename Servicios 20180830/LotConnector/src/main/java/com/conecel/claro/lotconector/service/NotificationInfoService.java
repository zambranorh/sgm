package com.conecel.claro.lotconector.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationInfoService {
	
	@Value("${connectTimeout}")	
	private int connectTimeout;

	@Value("${readTimeout}")	
	private int readTimeout;
	
	@Value("${urlNotify}")
	private String urlNotify;
	
	@Value("${sender}")
	private String sender;
	
	@Value("${recipient}")
	private String recipient;

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getUrlNotify() {
		return urlNotify;
	}

	public void setUrlNotify(String urlNotify) {
		this.urlNotify = urlNotify;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	

}
