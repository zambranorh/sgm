package regularizacion.userservice.services.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import regularizacion.userservice.models.RCProducto;
import regularizacion.userservice.models.RCVenta;
import regularizacion.userservice.repository.SalesRepository;
import regularizacion.userservice.services.SalesService;

@Service
public class SalesServiceImpl implements SalesService{

	private static final Logger LOG = LoggerFactory.getLogger(SalesService.class);

	@Autowired
	private SalesRepository salesRepository;
	//private RCVenta rcVentaNueva;
	
	
	@Override
	public RCVenta getVentaByOrden(BigDecimal numeroOrden) {
		// TODO Auto-generated method stub
		return salesRepository.findBynumeroOrden(numeroOrden);
	}

	@Override
	public RCProducto findByidProducto(RCVenta rcVenta) {
		// TODO Auto-generated method stub
		return salesRepository.findByidProducto(rcVenta);
	}

}
