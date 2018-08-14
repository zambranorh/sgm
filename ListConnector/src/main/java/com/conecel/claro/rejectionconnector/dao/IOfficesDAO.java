package com.conecel.claro.rejectionconnector.dao;

import java.util.List;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.dto.Offices;

public interface IOfficesDAO {

	List<Offices> obtieneOficnas(ChannelInfo channelInfo);
}
