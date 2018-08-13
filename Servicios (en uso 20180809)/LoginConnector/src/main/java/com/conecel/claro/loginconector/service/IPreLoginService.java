package com.conecel.claro.loginconector.service;

import com.conecel.claro.loginconector.util.PreLoginResponse;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;

public interface IPreLoginService {
	
	PreLoginResponse userInfo(PreLoginInfo preLoginInfo);

}
