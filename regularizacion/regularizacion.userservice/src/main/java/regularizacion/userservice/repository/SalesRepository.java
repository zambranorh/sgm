package regularizacion.userservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import regularizacion.userservice.models.RCVenta;
import regularizacion.userservice.models.RCProducto;
import java.math.BigDecimal;

@Transactional
public interface SalesRepository extends CrudRepository<RCVenta, BigDecimal> {
	
	RCVenta findBynumeroOrden(BigDecimal numeroOrden);
	
/*	RCCliente rcClienteByRCVenta(RCVenta rcVenta);
	
	RCProducto rcProductoByRCVenta(RCVenta rcVenta);
	RCFinanciera rcFinancieraByRCVenta(RCVenta rcVenta);
	RCFormasPagos rcFormasPagosByRCVenta(RCVenta rcVenta);
	RCOficina rcOficinaByRCVenta(RCVenta rcVenta);
	RCVendedor rcVendedorByRCVenta(RCVenta rcVenta); */
	
	RCProducto findByidProducto(RCVenta rcVenta);
	

}
