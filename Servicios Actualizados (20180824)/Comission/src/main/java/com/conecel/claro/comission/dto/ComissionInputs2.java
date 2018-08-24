package com.conecel.claro.comission.dto;

import java.io.Serializable;

public class ComissionInputs2 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	private String channelId;
	private String sellerId;
	private String penaltyId;
	private String startDate; 
	private String endDate;
	
	public ComissionInputs2() {}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getPenaltyId() {
		return penaltyId;
	}

	public void setPenaltyId(String penaltyId) {
		this.penaltyId = penaltyId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ComissionInputs2(String channelId, String sellerId, String penaltyId, String startDate, String endDate) {
		super();
		this.channelId = channelId;
		this.sellerId = sellerId;
		this.penaltyId = penaltyId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ComissionInputs2 [channelId=" + channelId + ", sellerId=" + sellerId + ", penaltyId=" + penaltyId
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

	

}
