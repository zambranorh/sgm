package com.conecel.claro.comissionconnector.dto.cannonical;

import com.conecel.claro.comissionconector.dto.entities.OperationInfo;

public class CommonHeaderResponse {
	
private OperationInfo operationInfo;
	
	public CommonHeaderResponse(OperationInfo operationInfo) {
		this.setOperationInfo(operationInfo);
	}

	public OperationInfo getOperationInfo() {
		return operationInfo;
	}

	public void setOperationInfo(OperationInfo operationInfo) {
		this.operationInfo = operationInfo;
	}

}
