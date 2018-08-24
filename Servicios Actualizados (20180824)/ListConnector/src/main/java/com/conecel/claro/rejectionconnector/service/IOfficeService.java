package com.conecel.claro.rejectionconnector.service;

import com.conecel.claro.rejectionconnector.dto.ChannelInfo;
import com.conecel.claro.rejectionconnector.util.OfficesResponse;

public interface IOfficeService {

	OfficesResponse getOffices(ChannelInfo channelInfo);
}
