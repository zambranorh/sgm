package com.conecel.claro.loginconector.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.loginconector.service.IPreLoginService;
import com.conecel.claro.loginconector.util.PreLoginResponse;
import com.conecel.claro.loginconnector.dto.PreLoginInfo;
//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
@RequestMapping("/login")
public class PreLoginApi {

	PreLoginResponse preLoginResponse;
	
	@Autowired
	IPreLoginService preLoginService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public PreLoginResponse getUserInfo(@RequestBody PreLoginInfo preLoginInfo) {
		preLoginResponse=preLoginService.userInfo(preLoginInfo);
		return preLoginResponse;
	}
}
