package com.conecel.claro.salesconector.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conecel.claro.salesconector.service.IExportFileService;
import com.conecel.claro.salesconector.service.IPreSalesService;
import com.conecel.claro.salesconector.util.PreSalesResponse;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;
//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
public class PreSalesApi {
	
	PreSalesResponse preSalesResponse;
	@Autowired
	IPreSalesService preSalesService;
	@Autowired
	IExportFileService exportFileServcice;
	
	
	
	@RequestMapping(value = "/SalesInfo", method = RequestMethod.POST)
	public PreSalesResponse getSalesDetail(@RequestBody PreSalesInfo preSalesInfo) {

		preSalesResponse = preSalesService.salesDetail(preSalesInfo);
		return preSalesResponse;

	}
	
	@RequestMapping(value = "/ExcelExportG", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadEXCELFileG() throws IOException {
		
		PreSalesInfo preSalesInfo= new PreSalesInfo();
		preSalesInfo.setOrder("");
		preSalesInfo.setStartDate("");
		preSalesInfo.setEndDate("");
		preSalesInfo.setOfficceId("");
		preSalesInfo.setChannelId("CAC");

		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(preSalesInfo).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(preSalesInfo)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/PdfExportG", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFileG() throws IOException {
		PreSalesInfo preSalesInfo= new PreSalesInfo();
		preSalesInfo.setOrder("");
		preSalesInfo.setStartDate("");
		preSalesInfo.setEndDate("");
		preSalesInfo.setOfficceId("");
		preSalesInfo.setChannelId("CAC");
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(preSalesInfo).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(preSalesInfo)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/ExcelExport", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> downloadEXCELFile(@RequestBody PreSalesInfo preSalesInfo) throws IOException {
		
		

		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(preSalesInfo).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(preSalesInfo)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/PdfExport", method = RequestMethod.POST, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestBody PreSalesInfo preSalesInfo) throws IOException {
	
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(preSalesInfo).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(preSalesInfo)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
