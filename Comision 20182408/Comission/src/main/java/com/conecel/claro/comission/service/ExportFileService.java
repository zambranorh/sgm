package com.conecel.claro.comission.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
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
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ExportFileService implements IExportFileService {
	
	@Autowired
	IComissionResultService comissionResultService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(ComissionInputs comissionInputs) throws Exception {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A3.rotate());

		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.setPageSize(PageSize.A3);
		document.open();
		
		List<Comission> comissionResult = comissionResultService.obtieneComisiones(comissionInputs);
		
		PdfPTable table = new PdfPTable(10);

		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);
		table.setSpacingBefore(0f);
		table.setSpacingAfter(0f);


		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		
		
		table.addCell("No. Orden");
		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Cuenta");
		table.addCell("Id Vendedor");
		table.addCell("Nombre");
		table.addCell("Canal");
		table.addCell("Localidad");
		table.addCell("Dias");
		table.addCell("SubComision");
		table.addCell("Penalizacion");
		table.addCell("Comision");
		
		table.getDefaultCell().setBackgroundColor(GrayColor.white);
		
		for (Comission fee : comissionResult) {
			table.addCell(String.valueOf(fee.getIdOrder()));
			table.addCell(String.valueOf(fee.getAccount()));
			table.addCell(String.valueOf(fee.getSellerId()));
			table.addCell(String.valueOf(fee.getSellerName()));
			table.addCell(String.valueOf(fee.getChannel()));
			table.addCell(String.valueOf(fee.getLocationId()));
			table.addCell(String.valueOf(fee.getDeliveryDays()));
			table.addCell(String.valueOf(fee.getSubComission()));
			table.addCell(String.valueOf(fee.getPenaltyValue()));
			table.addCell(String.valueOf(fee.getComissionValue()));
			
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
		Sheet sheet = workbook.createSheet("Comision");
		
		List<Comission> comissionResult = comissionResultService.obtieneComisiones(comissionInputs);
		
		CellStyle style = workbook.createCellStyle();

		CellStyle style2 = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setBorderTop(CellStyle.BORDER_THIN);

		style2.setBorderBottom(CellStyle.BORDER_THIN);
		style2.setBorderLeft(CellStyle.BORDER_THIN);
		style2.setBorderRight(CellStyle.BORDER_THIN);
		style2.setBorderTop(CellStyle.BORDER_THIN);

		Font font = workbook.createFont();
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("No. Orden");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Cuenta");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Vendedor");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Nombre");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Canal");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Localidad");
		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Dias");
		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("SubComision");
		header.getCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Penalizacion");
		header.getCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Comision");
		header.getCell(9).setCellStyle(style);
		
		int rowNum = 1;
		
		for (Comission fee : comissionResult) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(fee.getIdOrder());
			row.getCell(0).setCellStyle(style2);
			row.createCell(1).setCellValue(fee.getAccount());
			row.getCell(1).setCellStyle(style2);
			row.createCell(2).setCellValue(fee.getSellerId());
			row.getCell(2).setCellStyle(style2);
			row.createCell(3).setCellValue(fee.getSellerName());
			row.getCell(3).setCellStyle(style2);
			row.createCell(4).setCellValue(fee.getChannel());
			row.getCell(4).setCellStyle(style2);
			row.createCell(5).setCellValue(fee.getLocationId());
			row.getCell(5).setCellStyle(style2);
			row.createCell(6).setCellValue(fee.getDeliveryDays());
			row.getCell(6).setCellStyle(style2);
			row.createCell(7).setCellValue(fee.getSubComission());
			row.getCell(7).setCellStyle(style2);
			row.createCell(8).setCellValue(fee.getPenaltyValue());
			row.getCell(8).setCellStyle(style2);
			row.createCell(9).setCellValue(fee.getComissionValue());
			row.getCell(9).setCellStyle(style2);
			
			
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
