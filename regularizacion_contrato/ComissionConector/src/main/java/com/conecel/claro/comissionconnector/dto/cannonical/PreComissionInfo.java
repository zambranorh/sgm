package com.conecel.claro.comissionconnector.dto.cannonical;

import com.conecel.claro.comissionconector.dto.entities.PenaltyInfo;
import com.conecel.claro.comissionconector.dto.entities.SalesChannelInfo;

public class PreComissionInfo {
	
	private Double amount;
	private SalesChannelInfo salesChannel;
	private PenaltyInfo penaltyInfo;
	
	public PreComissionInfo() {}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public SalesChannelInfo getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(SalesChannelInfo salesChannel) {
		this.salesChannel = salesChannel;
	}

	public PenaltyInfo getPenaltyInfo() {
		return penaltyInfo;
	}

	public void setPenaltyInfo(PenaltyInfo penaltyInfo) {
		this.penaltyInfo = penaltyInfo;
	}
	
	
	
	

}
