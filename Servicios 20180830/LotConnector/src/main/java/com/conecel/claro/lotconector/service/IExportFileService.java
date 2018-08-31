package com.conecel.claro.lotconector.service;

import java.io.InputStream;

import com.conecel.claro.lotconnector.dto.PreLotInfo;

public interface IExportFileService {
	
	public InputStream buildPdfDocument(PreLotInfo preLotInfo) throws Exception;
	
	
	public InputStream buildExcelDocument(PreLotInfo preLotInfo) throws Exception;
}
