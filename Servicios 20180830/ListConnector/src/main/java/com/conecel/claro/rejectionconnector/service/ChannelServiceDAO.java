package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dao.IChannelDAO;
import com.conecel.claro.rejectionconnector.dto.Channel;

@Service
public class ChannelServiceDAO implements IChannelServiceDAO{
	
	@Autowired
	IChannelDAO channelDAO;

	@Override
	public List<Channel> getChannels() {
		
		return channelDAO.obtieneCanales();
	}

}
