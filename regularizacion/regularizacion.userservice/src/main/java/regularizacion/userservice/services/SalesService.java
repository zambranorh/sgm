package regularizacion.userservice.services;

import java.math.BigDecimal;

import regularizacion.userservice.models.RCVenta;
import regularizacion.userservice.models.RCProducto;

public interface SalesService {
	RCVenta getVentaByOrden(BigDecimal rcVenta);
	RCProducto findByidProducto(RCVenta rcVenta);

}
