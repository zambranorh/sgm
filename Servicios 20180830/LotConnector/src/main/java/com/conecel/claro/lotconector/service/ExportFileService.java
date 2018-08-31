package com.conecel.claro.lotconector.service;

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

import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;
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
	ILotResultService lotResultService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(PreLotInfo preLotInfo) throws Exception {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A3.rotate());

		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.setPageSize(PageSize.A3);
		document.open();

		List<LotResult> lotResult = lotResultService.obtieneRegulrizaciones(preLotInfo);

		PdfPTable table = new PdfPTable(15);

		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);
		table.setSpacingBefore(0f);
		table.setSpacingAfter(0f);


		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		
		table.addCell("No. Lote");
		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Fecha Lote");
		table.addCell("No. Orden");
		table.addCell("Id Cliente");
		table.addCell("Fecha Activacion");
		table.addCell("Usuario Ingreso");
		table.addCell("Forma Pago");
		table.addCell("Institucion Financiera");
		table.addCell("Id Oficina");
		table.addCell("Oficina");
		table.addCell("Dias");
		table.addCell("Estado");
		table.addCell("Motivo");
		table.addCell("Observacion");
		table.addCell("Usuario Regularizacion");
		
		table.getDefaultCell().setBackgroundColor(GrayColor.white);

		for (LotResult lot : lotResult) {
			table.addCell(String.valueOf(lot.getNumeroLote()));
			table.addCell(String.valueOf(lot.getFechaLote()));
			table.addCell(String.valueOf(lot.getOrderId()));
			table.addCell(String.valueOf(lot.getIdentidad()));
			table.addCell(String.valueOf(lot.getFechaActivacion()));
			table.addCell(String.valueOf(lot.getUsuarioIngreso()));
			table.addCell(String.valueOf(lot.getFormaPago()));
			table.addCell(String.valueOf(lot.getBanco()));
			table.addCell(String.valueOf(lot.getIdOficina()));
			table.addCell(String.valueOf(lot.getOficina()));
			table.addCell(String.valueOf(lot.getDias()));
			table.addCell(String.valueOf(lot.getEstado()));
			table.addCell(String.valueOf(lot.getMotivo()));
			table.addCell(String.valueOf(lot.getObservacion()));
			table.addCell(String.valueOf(lot.getUsuarioReg()));
		}

		
		document.add(table);
		document.close();

		InputStream isFromFirstData = new ByteArrayInputStream(buffer.toByteArray());

		return isFromFirstData;
	}

	@Override
	public InputStream buildExcelDocument(PreLotInfo preLotInfo) throws Exception {
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Lote");

		List<LotResult> lotResult = lotResultService.obtieneRegulrizaciones(preLotInfo);
		
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

		header.createCell(0).setCellValue("No. Lote");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Fecha Lote");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("No. Orden");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Id Cliente");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Fecha Activacion");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Usuario Ingreso");
		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Forma Pago");
		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Institucion Financiera");
		header.getCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Id Oficina");
		header.getCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Oficina");
		header.getCell(9).setCellStyle(style);
		header.createCell(10).setCellValue("Dias");
		header.getCell(10).setCellStyle(style);
		header.createCell(11).setCellValue("Estado");
		header.getCell(11).setCellStyle(style);
		header.createCell(12).setCellValue("Motivo");
		header.getCell(12).setCellStyle(style);
		header.createCell(13).setCellValue("Observacion");
		header.getCell(13).setCellStyle(style);
		header.createCell(14).setCellValue("Usuario Regularizacion");
		header.getCell(14).setCellStyle(style);

		int rowNum = 1;
		
		for (LotResult lot : lotResult) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(lot.getNumeroLote());
			row.getCell(0).setCellStyle(style2);
			row.createCell(1).setCellValue(lot.getFechaLote());
			row.getCell(1).setCellStyle(style2);
			row.createCell(2).setCellValue(lot.getOrderId());
			row.getCell(2).setCellStyle(style2);
			row.createCell(3).setCellValue(lot.getIdentidad());
			row.getCell(3).setCellStyle(style2);
			row.createCell(4).setCellValue(lot.getFechaActivacion());
			row.getCell(4).setCellStyle(style2);
			row.createCell(5).setCellValue(lot.getUsuarioIngreso());
			row.getCell(5).setCellStyle(style2);
			row.createCell(6).setCellValue(lot.getFormaPago());
			row.getCell(6).setCellStyle(style2);
			row.createCell(7).setCellValue(lot.getBanco());
			row.getCell(7).setCellStyle(style2);
			row.createCell(8).setCellValue(lot.getIdOficina());
			row.getCell(8).setCellStyle(style2);
			row.createCell(9).setCellValue(lot.getOficina());
			row.getCell(9).setCellStyle(style2);
			row.createCell(10).setCellValue(lot.getDias());
			row.getCell(10).setCellStyle(style2);
			row.createCell(11).setCellValue(lot.getEstado());
			row.getCell(11).setCellStyle(style2);
			row.createCell(12).setCellValue(lot.getMotivo());
			row.getCell(12).setCellStyle(style2);
			row.createCell(13).setCellValue(lot.getObservacion());
			row.getCell(13).setCellStyle(style2);
			row.createCell(14).setCellValue(lot.getUsuarioReg());
			row.getCell(14).setCellStyle(style2);
			
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
