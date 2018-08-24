package com.conecel.claro.rejectionconnector.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecel.claro.rejectionconnector.dto.Channel;
import com.conecel.claro.rejectionconnector.util.ChannelResponse;
@Service
public class ChannelService implements IChannelService{
	
	ChannelResponse channelResponse;
	
	@Autowired
	IChannelServiceDAO channelService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public ChannelResponse getChannels() {
		
		channelResponse = new ChannelResponse();
		
		try {
			List<Channel> channels =channelService.getChannels();
			channelResponse.setChannelResults(channels);
			
			if(channels.isEmpty()) {
				channelResponse.setCode("-1");
				channelResponse.setMessage("");
			}
			
			channelResponse.setCode("200");
			channelResponse.setMessage("OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error en servicio de obtencion de vendedores: ", e);
		}
		
		
		return channelResponse;
	}

}
