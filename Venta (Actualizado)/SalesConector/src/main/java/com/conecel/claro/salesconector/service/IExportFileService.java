package com.conecel.claro.salesconector.service;

import java.io.InputStream;

import com.conecel.claro.salesconnector.dto.PreSalesInfo;

public interface IExportFileService {
	
	public InputStream buildPdfDocument(PreSalesInfo preSalesInfo) throws Exception;
	
	
	public InputStream buildExcelDocument(PreSalesInfo preSalesInfo) throws Exception;
}
