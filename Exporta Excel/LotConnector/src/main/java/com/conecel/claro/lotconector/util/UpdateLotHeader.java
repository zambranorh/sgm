package com.conecel.claro.lotconector.util;

import java.util.Date;
import java.util.List;

public class UpdateLotHeader {
	private String lotId;
	private String regularized_user;
	private Date regularizedDate;
	private List<UpdateLotDetail> updateLotDetail;
	public String getRegularized_user() {
		return regularized_user;
	}
	public void setRegularized_user(String regularized_user) {
		this.regularized_user = regularized_user;
	}
	public Date getRegularizedDate() {
		return regularizedDate;
	}
	public void setRegularizedDate(Date regularizedDate) {
		this.regularizedDate = regularizedDate;
	}
	public List<UpdateLotDetail> getUpdateLotDetail() {
		return updateLotDetail;
	}
	public void setUpdateLotDetail(List<UpdateLotDetail> updateLotDetail) {
		this.updateLotDetail = updateLotDetail;
	}
	public String getLotId() {
		return lotId;
	}
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}
	
	
	
	
}
