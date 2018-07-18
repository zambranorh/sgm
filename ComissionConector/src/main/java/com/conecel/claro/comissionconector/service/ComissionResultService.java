package com.conecel.claro.comissionconector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comissionconector.dao.IComissionResultDAO;
import com.conecel.claro.comissionconnector.domain.ComissionResult;
@Service
public class ComissionResultService implements IComissionResultService {
	@Autowired
	IComissionResultDAO comissionResultDAO;
	@Override
	public ComissionResult obtieneComisionPorSolicitudYCuenta(String solicitud, String cuenta) {
		
		System.out.println("ENTREEEEEEE");
		
		return comissionResultDAO.obtieneComisionPorSolicitudYCuenta(solicitud, cuenta);
	}

}
