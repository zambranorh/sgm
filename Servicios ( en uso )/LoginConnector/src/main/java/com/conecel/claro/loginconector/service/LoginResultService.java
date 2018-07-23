package com.conecel.claro.loginconector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.loginconnector.dao.ILoginResultDAO;
import com.conecel.claro.loginconnector.domain.LoginResult;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;
@Service
public class LoginResultService implements ILoginResultService{
	
	@Autowired
	ILoginResultDAO loginResultDAO;

	@Override
	public List<LoginResult> obtieneUsuario(PreLoginInfo preLoginInfo) {
		// TODO Auto-generated method stub
		return loginResultDAO.obtieneUsuario(preLoginInfo);
	}
	

	

}
