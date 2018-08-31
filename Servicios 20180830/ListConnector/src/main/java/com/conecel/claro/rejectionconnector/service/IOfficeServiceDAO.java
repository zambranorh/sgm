package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.dto.Offices;

public interface IOfficeServiceDAO {
	
	List<Offices> getOffices(ChannelInfo channelInfo);

}
