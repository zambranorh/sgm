package com.conecel.claro.comissionconnector.dto.cannonical;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="CalculateRequestMessage")
@XmlType(propOrder= {
		"commonHeaderRequest",
		"precomissionInfo"
})
public class CalculateRequestMessage implements Serializable{
	
	private static final long serialVersionUID = 4163662735015957336L;
	private CommonHeaderRequest commonHeaderRequest;
	private PreComissionInfo precomissionInfo;
	
	public CommonHeaderRequest getCommonHeaderRequest() {
		return commonHeaderRequest;
	}
	public void setCommonHeaderRequest(CommonHeaderRequest commonHeaderRequest) {
		this.commonHeaderRequest = commonHeaderRequest;
	}
	
	public PreComissionInfo getBillingInfo() {
		return precomissionInfo;
	}
	public void setBillingInfo(PreComissionInfo comissionInfo) {
		this.precomissionInfo = comissionInfo;
	}

}
