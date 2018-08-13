package com.conecel.claro.lotconector.util;

import java.util.Date;
import java.util.List;

public class LotHeader {
	
	private String lotId;
	private Date lotDate;
	private List<LotDetail> lotDetail;
	
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	public Date getLotDate() {
		return lotDate;
	}
	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
	}
	public List<LotDetail> getLotDetail() {
		return lotDetail;
	}
	public void setLotDetail(List<LotDetail> lotDetail) {
		this.lotDetail = lotDetail;
	}
	
	

}
