package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.IReasonsDAO;
import com.conecel.claro.rejectionconnector.dto.Reasons;
@Service
public class ReasonServiceDAO implements IReasonServiceDAO{

	@Autowired
	IReasonsDAO reasonsDAO;
	
	@Override
	public List<Reasons> obtieneMotivos() {
		return reasonsDAO.obtieneMotivos();
	}

}
