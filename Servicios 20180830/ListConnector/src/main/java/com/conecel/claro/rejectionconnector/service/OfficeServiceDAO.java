package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.IOfficesDAO;
import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.dto.Offices;
@Service
public class OfficeServiceDAO implements IOfficeServiceDAO{
	
	@Autowired
	IOfficesDAO officeDAO;

	@Override
	public List<Offices> getOffices(ChannelInfo channelInfo) {
		return officeDAO.obtieneOficnas(channelInfo);
	}

}
