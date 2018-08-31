package com.conecel.claro.comission.service;

 import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComissionInfoService {
 

@Value("${connectTimeout}")	
private int connectTimeout;

@Value("${readTimeout}")	
private int readTimeout;
	


@Value("${informationService}")
private String informationService;

@Value("${dataSource}")
private String dataSource;

@Value("${urlMEis}")
private String urlMEis;

public int getConnectTimeout() {
	return connectTimeout;
}

public void setConnectTimeout(int connectTimeout) {
	this.connectTimeout = connectTimeout;
}

public int getReadTimeout() {
	return readTimeout;
}

public void setReadTimeout(int readTimeout) {
	this.readTimeout = readTimeout;
}

public String getInformationService() {
	return informationService;
}

public void setInformationService(String informationService) {
	this.informationService = informationService;
}

public String getDataSource() {
	return dataSource;
}

public void setDataSource(String dataSource) {
	this.dataSource = dataSource;
}

public String getUrlMEis() {
	return urlMEis;
}

public void setUrlMEis(String urlMEis) {
	this.urlMEis = urlMEis;
}





}
