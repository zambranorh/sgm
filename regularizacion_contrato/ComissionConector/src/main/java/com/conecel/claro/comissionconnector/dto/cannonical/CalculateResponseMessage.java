package com.conecel.claro.comissionconnector.dto.cannonical;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



import com.conecel.claro.comissionconector.dto.entities.ComissionInfo;




@XmlType(propOrder = {
		"commonHeaderResponse",
		"comissionInfo"
})
public class CalculateResponseMessage implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private CommonHeaderResponse commonHeaderResponse;
	private ComissionInfo comissionInfo;
	
	public CalculateResponseMessage() {}
	

	public CommonHeaderResponse getCommonHeaderResponse() {
		return commonHeaderResponse;
	}

	public void setCommonHeaderResponse(CommonHeaderResponse commonHeaderResponse) {
		this.commonHeaderResponse = commonHeaderResponse;
	}

}
