package com.conecel.claro.comission.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.comission.domain.Comission;
import com.conecel.claro.comission.dto.ComissionInputs;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ExportFileService implements IExportFileService {
	
	@Autowired
	IComissionResultService comissionResultService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(ComissionInputs comissionInputs) throws Exception {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.open();
		
		List<Comission> comissionResult = comissionResultService.obtieneComisiones(comissionInputs);
		
		Table table = new Table(7);
		table.addCell("No. Orden");
		table.addCell("Cuenta");
		table.addCell("Id Vendedor");
		table.addCell("Nombre");
		table.addCell("Canal");
		table.addCell("Localidad");
		table.addCell("Dias");
		
		for (Comission fee : comissionResult) {
			table.addCell(String.valueOf(fee.getIdOrder()));
			table.addCell(String.valueOf(fee.getAccount()));
			table.addCell(String.valueOf(fee.getSellerId()));
			table.addCell(String.valueOf(fee.getSellerName()));
			table.addCell(String.valueOf(fee.getChannel()));
			table.addCell(String.valueOf(fee.getLocationId()));
			table.addCell(String.valueOf(fee.getDeliveryDays()));
			
		}

		
		document.add(table);
		document.close();

		InputStream isFromFirstData = new ByteArrayInputStream(buffer.toByteArray());

		return isFromFirstData;
		

	}

	@Override
	public InputStream buildExcelDocument(ComissionInputs comissionInputs) throws Exception {
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Ventas");
		
		List<Comission> comissionResult = comissionResultService.obtieneComisiones(comissionInputs);
		
		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("No. Orden");
		// header.createCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Cuenta");
		// header.createCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Vendedor");
		// header.createCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Nombre");
		// header.createCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Canal");
		// header.createCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Localidad");
		// header.createCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Dias");
		
		int rowNum = 1;
		
		for (Comission fee : comissionResult) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(fee.getIdOrder());
			row.createCell(1).setCellValue(fee.getAccount());
			row.createCell(2).setCellValue(fee.getSellerId());
			row.createCell(3).setCellValue(fee.getSellerName());
			row.createCell(4).setCellValue(fee.getChannel());
			row.createCell(5).setCellValue(fee.getLocationId());
			row.createCell(6).setCellValue(fee.getDeliveryDays());
		}
		

		sheet.autoSizeColumn((short) 1);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		workbook.write(bos);
		byte[] barray = bos.toByteArray();
		InputStream is = new ByteArrayInputStream(barray);
		is.close();
		bos.close();
		workbook.close();

		return is;
	}

	

}
