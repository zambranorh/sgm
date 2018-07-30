package com.conecel.claro.loginconector.service;

import java.util.List;

import com.conecel.claro.loginconnector.domain.LoginResult;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;

public interface ILoginResultService {

	List<LoginResult> obtieneUsuario(PreLoginInfo preLoginInfo);

}
