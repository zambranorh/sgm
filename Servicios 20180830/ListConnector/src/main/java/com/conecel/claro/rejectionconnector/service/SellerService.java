package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Sellers;
import com.conecel.claro.rejectionconnector.util.SellersResponse;

@Service
public class SellerService implements ISellerService{
	
	SellersResponse sellersResponse;
	
	@Autowired
	ISellerServiceDAO sellerService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public SellersResponse getSellers() {
		sellersResponse = new SellersResponse();
		try {
			List<Sellers> sellers =sellerService.obtieneVendedores();
			sellersResponse.setSellerResults(sellers);
			
			if(sellers.isEmpty()) {
				sellersResponse.setCode("-1");
				sellersResponse.setMessage("");
			}
			
			sellersResponse.setCode("200");
			sellersResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de vendedores: ", e);
		}
		return sellersResponse;
	}

}
