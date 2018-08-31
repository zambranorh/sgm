package com.conecel.claro.lotconector.api;

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

import com.conecel.claro.lotconector.service.IExportFileService;
import com.conecel.claro.lotconector.service.IInsertLotDetailService;
import com.conecel.claro.lotconector.util.LotHeader;
import com.conecel.claro.lotconector.util.PreLotResponse;
import com.conecel.claro.lotconector.util.PreLotResponses;
import com.conecel.claro.lotconector.util.SequenceResponse;
import com.conecel.claro.lotconector.util.UpdateLotHeader;
import com.conecel.claro.lotconnector.dto.PreLotInfo;

//@CrossOrigin(origins = {"http://10.225.13.18:9955"}, maxAge = 3000)
@CrossOrigin(origins = {"*"}, maxAge = 3000)
@RestController
public class PreLotApi {
	
	PreLotResponse preLotResponse;
	
	PreLotResponses preLotResponses;
	
	SequenceResponse sequenceResponse;
	

	
	@Autowired
	IInsertLotDetailService insertLotDetailService;
	
	@Autowired
	IExportFileService exportFileServcice;
	
	@RequestMapping(value = "/LotInfo", method = RequestMethod.POST)
	public PreLotResponses getRegDetail(@RequestBody PreLotInfo preLotInfo)
	{
		preLotResponses= insertLotDetailService.regularizationDetail(preLotInfo);
		return preLotResponses;
	}
	
	@RequestMapping(value = "/LotCreation", method = RequestMethod.POST)
	public PreLotResponse lotCreation(@RequestBody LotHeader lotHeader) {
		
		
		preLotResponse = insertLotDetailService.grabarMaestroDetalle(lotHeader);
		
		
		
		return preLotResponse;
		
	}
	
	@RequestMapping(value = "/LotUpdate", method = RequestMethod.POST)
	public PreLotResponse lotUpdate(@RequestBody UpdateLotHeader updateLotHeader) {
		
		preLotResponse= insertLotDetailService.actualizarMaestroDetalle(updateLotHeader);
		
		
		
		return preLotResponse;
		
	}
	
	@RequestMapping(value = "/GetSequence", method = RequestMethod.GET)
	public SequenceResponse getSequence() {
		
		sequenceResponse= insertLotDetailService.getSequence();
		
		return sequenceResponse;
		
	}
	
	@RequestMapping(value = "/ExcelExportG", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadEXCELFile2() throws IOException {
		
		PreLotInfo preLotInfo= new PreLotInfo();
		preLotInfo.setCustomerId("");
		preLotInfo.setEndDate("");
		preLotInfo.setFinancialInstitution("");
		preLotInfo.setLotId("1_csm_cac_mall_del_sol");
		preLotInfo.setOrderId("");
		preLotInfo.setPaymentType("");
		preLotInfo.setSalesChannel("");
		preLotInfo.setStartDate("");
		
		
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(preLotInfo).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(preLotInfo)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/PdfExportG", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile2() throws IOException {
		PreLotInfo preLotInfo= new PreLotInfo();
		
		
		preLotInfo.setCustomerId("");
		preLotInfo.setEndDate("");
		preLotInfo.setFinancialInstitution("");
		preLotInfo.setLotId("1_csm_cac_mall_del_sol");
		preLotInfo.setOrderId("");
		preLotInfo.setPaymentType("");
		preLotInfo.setSalesChannel("");
		preLotInfo.setStartDate("");
		
		
		
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(preLotInfo).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(preLotInfo)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	
	@RequestMapping(value = "/ExcelExport", method = RequestMethod.POST)
	public ResponseEntity<InputStreamResource> downloadEXCELFile(@RequestBody PreLotInfo preLotInfo) throws IOException {
		
	
		
		
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildExcelDocument(preLotInfo).available())
					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
					.body(new InputStreamResource(exportFileServcice.buildExcelDocument(preLotInfo)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/PdfExport", method = RequestMethod.POST, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestBody PreLotInfo preLotInfo) throws IOException {
		
		
		
		
		try {
			return ResponseEntity.ok().contentLength(exportFileServcice.buildPdfDocument(preLotInfo).available())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(exportFileServcice.buildPdfDocument(preLotInfo)));
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	

}
