package com.conecel.claro.salesconector.service;

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

import com.conecel.claro.salesconnector.domain.SalesResult;
import com.conecel.claro.salesconnector.dto.PreSalesInfo;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ExportFileService implements IExportFileService {

	@Autowired
	ISalesResultService salesResultService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public InputStream buildPdfDocument(PreSalesInfo preSalesInfo) throws Exception {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, buffer);

		document.addCreator("DWR.war using iText");
		document.open();

		List<SalesResult> salesResult = salesResultService.obtieneDetalleVenta(preSalesInfo);

		Table table = new Table(16);
		table.addCell("No. Orden");
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

			
		Row header = sheet.createRow(0);
		
		
		header.createCell(0).setCellValue("No. Orden");
		//header.createCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Descripcion");
		//header.createCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Fecha Ingreso");
		//header.createCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Id Oficina");
		//header.createCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Oficina");
		//header.createCell(4).setCellStyle(style);
		header.createCell(5).setCellValue("Vendedor");
		//header.createCell(5).setCellStyle(style);
		header.createCell(6).setCellValue("Id Cliente");
		//header.createCell(6).setCellStyle(style);
		header.createCell(7).setCellValue("Producto");
		//header.createCell(7).setCellStyle(style);
		header.createCell(8).setCellValue("Valor Producto");
		//header.createCell(8).setCellStyle(style);
		header.createCell(9).setCellValue("Fecha Activacion");
		//header.createCell(9).setCellStyle(style);
		header.createCell(10).setCellValue("Estado");
		//header.createCell(10).setCellStyle(style);
		header.createCell(11).setCellValue("Forma Pago");
		header.createCell(12).setCellValue("Institucion Financiera");
		header.createCell(13).setCellValue("Cuenta");
		header.createCell(14).setCellValue("Usuario Regularizacion");
		header.createCell(15).setCellValue("Id Lote");

		

		int rowNum = 1;

		for (SalesResult sale : salesResult) {

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(sale.getNoOrden());

			row.createCell(1).setCellValue(sale.getDescripcionVenta());
			row.createCell(2).setCellValue(sale.getFechaIngreso());
			row.createCell(3).setCellValue(sale.getCodOficina());
			row.createCell(4).setCellValue(sale.getOficina());
			row.createCell(5).setCellValue(sale.getVendedor());
			row.createCell(6).setCellValue(sale.getCliente());
			row.createCell(7).setCellValue(sale.getDescripcionProducto());
			row.createCell(8).setCellValue(sale.getValorProducto());
			row.createCell(9).setCellValue(sale.getFechaActivacion());
			row.createCell(10).setCellValue(sale.getEstado());
			row.createCell(11).setCellValue(sale.getFormaPago());
			row.createCell(12).setCellValue(sale.getInstitucionFinanciera());
			row.createCell(13).setCellValue(sale.getCuenta());
			row.createCell(14).setCellValue(sale.getUsuarioReg());
			row.createCell(15).setCellValue(sale.getIdLote());

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
