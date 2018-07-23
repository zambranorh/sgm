package com.conecel.claro.comissionconector.service;


import com.conecel.claro.comissionconnector.domain.ComissionResult;

public interface IComissionResultService {

	public ComissionResult obtieneComisionPorSolicitudYCuenta(String solicitud, String cuenta);
}
