package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.ISellersDAO;
import com.conecel.claro.rejectionconnector.dto.Sellers;

@Service
public class SellerServiceDAO implements ISellerServiceDAO{
	
	@Autowired
	ISellersDAO sellersDAO;

	@Override
	public List<Sellers> obtieneVendedores() {

		return sellersDAO.obtieneVendedores();
	}

}
