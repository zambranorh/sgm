package regularizacion.userservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import regularizacion.userservice.models.*;
import regularizacion.userservice.services.SalesService;

@RestController
@RequestMapping("/regula/sale")
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	
	@RequestMapping("/{numeroOrden}")
	public RCVenta getVentaByOrden(@PathVariable String numeroOrden) {
		BigDecimal ordenNo = new BigDecimal(Integer.parseInt(numeroOrden));
		return salesService.getVentaByOrden(ordenNo);
	}
}
