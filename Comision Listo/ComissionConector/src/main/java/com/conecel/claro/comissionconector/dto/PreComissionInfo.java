package com.conecel.claro.comissionconector.dto;
import java.io.Serializable;

public class PreComissionInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String requestId; 
	private String accountId;
	private String channelId;
	private String locationId;
	private String deliveryDays;
	
	public PreComissionInfo() {}
	
	
	
	
	public String getRequestId() {
		return requestId;
	}




	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}




	public String getAccountId() {
		return accountId;
	}




	public void setAccountId(String accountId) {
		this.accountId = accountId;
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




	public String getDeliveryDays() {
		return deliveryDays;
	}




	public void setDeliveryDays(String deliveryDays) {
		this.deliveryDays = deliveryDays;
	}



 




	public PreComissionInfo(String requestId, String accountId, String channelId, String locationId,
			String deliveryDays) {
		super();
		this.requestId = requestId;
		this.accountId = accountId;
		this.channelId = channelId;
		this.locationId = locationId;
		this.deliveryDays = deliveryDays;
	}
	@Override
	public String toString() {
		return "PreComissionInfo [requestId=" + requestId + ", accountId=" + accountId + ", channelId=" + channelId
				+ ", locationId=" + locationId + ", deliveryDays=" + deliveryDays + "]";
	}




	

}
