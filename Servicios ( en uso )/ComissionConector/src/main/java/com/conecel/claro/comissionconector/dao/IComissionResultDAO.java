package com.conecel.claro.comissionconector.dao;



import com.conecel.claro.comissionconnector.domain.ComissionResult;

public interface IComissionResultDAO {

	public ComissionResult obtieneComisionPorSolicitudYCuenta(String solicitud, String cuenta);
	
	
}
