package com.conecel.claro.loginconector.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.loginconector.util.PreLoginResponse;
import com.conecel.claro.loginconnector.domain.LoginResult;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;
@Service
public class PreLoginService implements IPreLoginService{
	
	PreLoginResponse preLoginResponse;
	
	@Autowired
	ILoginResultService loginResultService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public PreLoginResponse userInfo(PreLoginInfo preLoginInfo) {
		preLoginResponse=new PreLoginResponse();
		
		try {
			
			List<LoginResult> loginResult = loginResultService.obtieneUsuario(preLoginInfo);
			preLoginResponse.setLoginResult(loginResult);
			
			if(loginResult == null) {
				preLoginResponse.setCode("-1");
				preLoginResponse.setMessage("Error al recuperar los datos");
				return preLoginResponse;
			}
			
			String token= UUID.randomUUID().toString();
			
			
			
			
			preLoginResponse.setToken(token);
			preLoginResponse.setCode("0");
			preLoginResponse.setMessage("OK");
			
		}catch(Exception e)
		{
			preLoginResponse.setCode("-1");
			preLoginResponse.setMessage("Error al recuperar los datos");
			
			log.error("Hubo error", e);
			
		}
		
		return preLoginResponse;
	}
	
	

}
