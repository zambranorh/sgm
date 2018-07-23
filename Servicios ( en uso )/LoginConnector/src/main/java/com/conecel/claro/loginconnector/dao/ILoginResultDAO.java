package com.conecel.claro.loginconnector.dao;

import java.util.List;

import com.conecel.claro.loginconnector.domain.LoginResult;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;

public interface ILoginResultDAO {

	

	List<LoginResult> obtieneUsuario(PreLoginInfo PreLoginInfo);

}
