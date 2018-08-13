package com.conecel.claro.lotconector.service;

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

import com.conecel.claro.lotconnector.dto.LotResult;
import com.conecel.claro.lotconnector.dto.PreLotInfo;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ExportFileService implements IExportFileService {

	@Autowired
	ILotResultService lotResultService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(PreLotInfo preLotInfo) throws Exception {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.open();

		List<LotResult> lotResult = lotResultService.obtieneRegulrizaciones(preLotInfo);

		Table table = new Table(15);
		table.addCell("No. Lote");
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
		Sheet sheet = workbook.createSheet("Ventas");

		List<LotResult> lotResult = lotResultService.obtieneRegulrizaciones(preLotInfo);

		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("No. Lote");
		// header.createCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Fecha Lote");
		// header.createCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("No. Orden");
		// header.createCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Id Cliente");
		// header.createCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Fecha Activacion");
		// header.createCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Usuario Ingreso");
		// header.createCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Forma Pago");
		// header.createCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Institucion Financiera");
		// header.createCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Id Oficina");
		// header.createCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Oficina");
		// header.createCell(9).setCellStyle(style);
		header.createCell(10).setCellValue("Dias");
		// header.createCell(10).setCellStyle(style);
		header.createCell(11).setCellValue("Estado");
		header.createCell(12).setCellValue("Motivo");
		header.createCell(13).setCellValue("Observacion");
		header.createCell(14).setCellValue("Usuario Regularizacion");

		int rowNum = 1;
		
		for (LotResult lot : lotResult) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(lot.getNumeroLote());
			row.createCell(1).setCellValue(lot.getFechaLote());
			row.createCell(2).setCellValue(lot.getOrderId());
			row.createCell(3).setCellValue(lot.getIdentidad());
			row.createCell(4).setCellValue(lot.getFechaActivacion());
			row.createCell(5).setCellValue(lot.getUsuarioIngreso());
			row.createCell(6).setCellValue(lot.getFormaPago());
			row.createCell(7).setCellValue(lot.getBanco());
			row.createCell(8).setCellValue(lot.getIdOficina());
			row.createCell(9).setCellValue(lot.getOficina());
			row.createCell(10).setCellValue(lot.getDias());
			row.createCell(11).setCellValue(lot.getEstado());
			row.createCell(12).setCellValue(lot.getMotivo());
			row.createCell(13).setCellValue(lot.getObservacion());
			row.createCell(14).setCellValue(lot.getUsuarioReg());
			
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
