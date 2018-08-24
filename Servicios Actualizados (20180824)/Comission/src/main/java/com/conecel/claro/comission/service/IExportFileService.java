package com.conecel.claro.comission.service;

import java.io.InputStream;

import com.conecel.claro.comission.dto.ComissionInputs;


public interface IExportFileService {
	
	public InputStream buildPdfDocument(ComissionInputs comissionInputs) throws Exception;
	
	
	public InputStream buildExcelDocument(ComissionInputs comissionInputs) throws Exception;
}
