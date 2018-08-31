package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.IPenaltiesDAO;
import com.conecel.claro.rejectionconnector.dto.Penalties;
@Service
public class PenaltiesServiceDAO implements IPenaltiesServiceDAO{
	
	@Autowired
	IPenaltiesDAO penaltiesDAO;

	@Override
	public List<Penalties> obtienePenalizaciones() {
		// TODO Auto-generated method stub
		return penaltiesDAO.obitenePenalidades();
	}

}
