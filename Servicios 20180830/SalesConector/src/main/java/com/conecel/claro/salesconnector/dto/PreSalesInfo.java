package com.conecel.claro.salesconnector.dto;

import java.io.Serializable;

public class PreSalesInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String order;
	private String startDate; 
	private String endDate;
	private String officceId;
	private String channelId;
	private String lotId;
	private String status;
	
	public PreSalesInfo() {}

	public PreSalesInfo(String order) {
		super();
		this.order = order;
	}


	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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

	public String getOfficceId() {
		return officceId;
	}

	public void setOfficceId(String officceId) {
		this.officceId = officceId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PreSalesInfo(String order, String startDate, String endDate, String officceId, String channelId,
			String lotId, String status) {
		super();
		this.order = order;
		this.startDate = startDate;
		this.endDate = endDate;
		this.officceId = officceId;
		this.channelId = channelId;
		this.lotId = lotId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "PreSalesInfo [order=" + order + ", startDate=" + startDate + ", endDate=" + endDate + ", officceId="
				+ officceId + ", channelId=" + channelId + ", lotId=" + lotId + ", status=" + status + "]";
	}

	
	

	
	
	
	

}
