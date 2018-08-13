package com.conecel.claro.loginconector.service;

import java.util.Calendar;
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
			
			if(loginResult == null || loginResult.isEmpty()) {
				preLoginResponse.setCode("204");
				preLoginResponse.setMessage("Credenciales incorrectas");
				preLoginResponse.setToken("");
				preLoginResponse.setExpiresAt(null);
				return preLoginResponse;
			}
			
			String token= UUID.randomUUID().toString();
			
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MILLISECOND, 3000000);
			long expiresAt = calendar.getTimeInMillis();
			
			
			preLoginResponse.setExpiresAt(expiresAt);
			preLoginResponse.setToken(token);
			preLoginResponse.setCode("200");
			preLoginResponse.setMessage("OK");
			
		}catch(Exception e)
		{
			preLoginResponse.setCode("-1");
			preLoginResponse.setMessage("Error al validar credenciales!");
			
			log.error("Error en servicio de validacion de credenciales: ", e);
			
		}
		
		return preLoginResponse;
	}
	
   

	
	

}
