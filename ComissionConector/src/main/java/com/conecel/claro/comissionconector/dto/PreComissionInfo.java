package com.conecel.claro.comissionconector.dto;
import java.io.Serializable;

public class PreComissionInfo implements Serializable{
	private static final long serialVersionUID = 4894729030347835498L;
	
	private Long requestId; 
	private Long accountId;
	private String channelId;
	private String locationId;
	private Long deliveryDays;
	
	public PreComissionInfo() {}
	
	
	
	
	public Long getRequestId() {
		return requestId;
	}




	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}




	public Long getAccountId() {
		return accountId;
	}




	public void setAccountId(Long accountId) {
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




	public Long getDeliveryDays() {
		return deliveryDays;
	}




	public void setDeliveryDays(Long deliveryDays) {
		this.deliveryDays = deliveryDays;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public PreComissionInfo(Long requestId, Long accountId, String channelId, String locationId,
			Long deliveryDays) {
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
