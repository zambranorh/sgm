package com.conecel.claro.salesconector.service;

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

import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ExportFileService implements IExportFileService {

	@Autowired
	ISalesResultService salesResultService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(PreSalesInfo preSalesInfo) throws Exception {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document(PageSize.A3.rotate());

		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.setPageSize(PageSize.A3);
		document.open();

		

		List<SalesResult> salesResult = salesResultService.obtieneDetalleVenta(preSalesInfo);

		PdfPTable table = new PdfPTable(16);

		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);
		table.setSpacingBefore(0f);
		table.setSpacingAfter(0f);


		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		
		table.addCell("No. Orden");
		table.getDefaultCell().setBackgroundColor(GrayColor.red);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell("Descripcion");
		table.addCell("Fecha Ingreso");
		table.addCell("Id Oficina");
		table.addCell("Oficina");
		table.addCell("Vendedor");
		table.addCell("Id Cliente");
		table.addCell("Producto");
		table.addCell("Valor Producto");
		table.addCell("Fecha Activacion");
		table.addCell("Estado");
		table.addCell("Forma Pago");
		table.addCell("Institucion Financiera");
		table.addCell("Cuenta");
		table.addCell("Usuario Regularizacion");
		table.addCell("Id Lote");

		table.getDefaultCell().setBackgroundColor(GrayColor.white);

		for (SalesResult sale : salesResult) {
			table.addCell(String.valueOf(sale.getNoOrden()));
			table.addCell(String.valueOf(sale.getDescripcionVenta()));
			table.addCell(String.valueOf(sale.getFechaIngreso()));
			table.addCell(String.valueOf(sale.getCodOficina()));
			table.addCell(String.valueOf(sale.getOficina()));
			table.addCell(String.valueOf(sale.getVendedor()));
			table.addCell(String.valueOf(sale.getCliente()));
			table.addCell(String.valueOf(sale.getDescripcionProducto()));
			table.addCell(String.valueOf(sale.getValorProducto()));
			table.addCell(String.valueOf(sale.getFechaActivacion()));
			table.addCell(String.valueOf(sale.getEstado()));
			table.addCell(String.valueOf(sale.getFormaPago()));
			table.addCell(String.valueOf(sale.getInstitucionFinanciera()));
			table.addCell(String.valueOf(sale.getCuenta()));
			table.addCell(String.valueOf(sale.getUsuarioReg()));
			table.addCell(String.valueOf(sale.getIdLote()));

		}

		document.add(table);
		document.close();

		InputStream isFromFirstData = new ByteArrayInputStream(buffer.toByteArray());

		return isFromFirstData;
	}

	@Override
	public InputStream buildExcelDocument(PreSalesInfo preSalesInfo) throws Exception {

		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Ventas");

		List<SalesResult> salesResult = salesResultService.obtieneDetalleVenta(preSalesInfo);

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
		header.createCell(1).setCellValue("Descripcion");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Fecha Ingreso");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Id Oficina");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Oficina");
		header.getCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Vendedor");
		header.getCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Id Cliente");
		header.getCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Producto");
		header.getCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Valor Producto");
		header.getCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Fecha Activacion");
		header.getCell(9).setCellStyle(style);
		header.createCell(10).setCellValue("Estado");
		header.getCell(10).setCellStyle(style);
		header.createCell(11).setCellValue("Forma Pago");
		header.getCell(11).setCellStyle(style);
		header.createCell(12).setCellValue("Institucion Financiera");
		header.getCell(12).setCellStyle(style);
		header.createCell(13).setCellValue("Cuenta");
		header.getCell(13).setCellStyle(style);
		header.createCell(14).setCellValue("Usuario Regularizacion");
		header.getCell(14).setCellStyle(style);
		header.createCell(15).setCellValue("Id Lote");
		header.getCell(15).setCellStyle(style);

		int rowNum = 1;

		for (SalesResult sale : salesResult) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(sale.getNoOrden());
			row.getCell(0).setCellStyle(style2);
			row.createCell(1).setCellValue(sale.getDescripcionVenta());
			row.getCell(1).setCellStyle(style2);
			row.createCell(2).setCellValue(sale.getFechaIngreso());
			row.getCell(2).setCellStyle(style2);
			row.createCell(3).setCellValue(sale.getCodOficina());
			row.getCell(3).setCellStyle(style2);
			row.createCell(4).setCellValue(sale.getOficina());
			row.getCell(4).setCellStyle(style2);
			row.createCell(5).setCellValue(sale.getVendedor());
			row.getCell(5).setCellStyle(style2);
			row.createCell(6).setCellValue(sale.getCliente());
			row.getCell(6).setCellStyle(style2);
			row.createCell(7).setCellValue(sale.getDescripcionProducto());
			row.getCell(7).setCellStyle(style2);
			row.createCell(8).setCellValue(sale.getValorProducto());
			row.getCell(8).setCellStyle(style2);
			row.createCell(9).setCellValue(sale.getFechaActivacion());
			row.getCell(9).setCellStyle(style2);
			row.createCell(10).setCellValue(sale.getEstado());
			row.getCell(10).setCellStyle(style2);
			row.createCell(11).setCellValue(sale.getFormaPago());
			row.getCell(11).setCellStyle(style2);
			row.createCell(12).setCellValue(sale.getInstitucionFinanciera());
			row.getCell(12).setCellStyle(style2);
			row.createCell(13).setCellValue(sale.getCuenta());
			row.getCell(13).setCellStyle(style2);
			row.createCell(14).setCellValue(sale.getUsuarioReg());
			row.getCell(14).setCellStyle(style2);
			row.createCell(15).setCellValue(sale.getIdLote());
			row.getCell(15).setCellStyle(style2);

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
