package com.conecel.claro.comission.api;

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


import com.conecel.claro.comission.dto.ComissionInputs2;
import com.conecel.claro.comission.dto.ComissionPeriod;
import com.conecel.claro.comission.service.ComissionService;
import com.conecel.claro.comission.service.IExportFileService;

import com.conecel.claro.comission.util.ComissionResponse2;
import com.conecel.claro.comission.util.GeneratedComissionResponse;

//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = { "*" }, maxAge = 3000)
@RestController
public class ComissionApi {

	GeneratedComissionResponse generatedComissionResponse;

	
	
	ComissionResponse2 comissionResponse2;

	@Autowired
	ComissionService comissionService;

	@Autowired
	IExportFileService exportFileServcice;

	/*@RequestMapping(value = "/ComissionCreate", method = RequestMethod.POST)
	public GeneratedComissionResponse generateComission(@RequestBody ComissionPeriod comissionPeriod) {

		generatedComissionResponse = comissionService.generaComision(comissionPeriod);

		return generatedComissionResponse;

	}*/
	
	
	@RequestMapping(value = "/ComissionsCreate", method = RequestMethod.POST)
	public GeneratedComissionResponse generateComissions(@RequestBody ComissionPeriod comissionPeriod) {

		generatedComissionResponse = comissionService.generaComision2(comissionPeriod);

		return generatedComissionResponse;

	}
	

	/*@RequestMapping(value = "/ComissionInfo", method = RequestMethod.POST)
	public ComissionResponse getComission(@RequestBody ComissionInputs comissionInputs) {

		comissionResponse = comissionService.getComissions(comissionInputs);

		return comissionResponse;

	}*/
	
	@RequestMapping(value = "/ComissionsInfo", method = RequestMethod.POST)
	public ComissionResponse2 getComissions(@RequestBody ComissionInputs2 comissionInputs) {

		comissionResponse2 = comissionService.getComissions2(comissionInputs);

		return comissionResponse2;

	}
/*
	@RequestMapping(value = "/ExcelExport", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> downloadEXCELFile(@RequestBody ComissionInputs comissionInputs)
			throws IOException {



		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(comissionInputs).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(comissionInputs)));
		} catch (Exception e) {
		
			e.printStackTrace();
			return null;
		}
	}


	@RequestMapping(value = "/PdfExport", method = RequestMethod.POST, produces = "application/pdf")

	public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestBody ComissionInputs comissionInputs)
			throws IOException {



		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(comissionInputs).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(comissionInputs)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/ExcelExportG", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadEXCELFileG() throws IOException {

		ComissionInputs comissionInputs = new ComissionInputs();

		comissionInputs.setChannelId("CAC");
		comissionInputs.setLocationId("");
		comissionInputs.setRequestId("");
		comissionInputs.setSellerId("");

		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(comissionInputs).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(comissionInputs)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/PdfExportG", method = RequestMethod.GET, produces = "application/pdf")

	public ResponseEntity<InputStreamResource> downloadPDFFileG() throws IOException {

		ComissionInputs comissionInputs = new ComissionInputs();

		comissionInputs.setChannelId("CAC");
		comissionInputs.setLocationId("");
		comissionInputs.setRequestId("");
		comissionInputs.setSellerId("");

		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(comissionInputs).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(comissionInputs)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}*/
}
