package com.conecel.claro.comissionconector.service;

 import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComissionInfoService {
 

@Value("${connectTimeout}")	
private int connectTimeout;

@Value("${readTimeout}")	
private int readTimeout;
	
	
@Value("${da.gye.plazo}")
private Long plazo_da_gye;

@Value("${da.oc.plazo}")
private Long plazo_oc_da;

@Value("${da.multa.ft}")
private Long multa_da_ft;

@Value("${da.multa.ne}")
private Long multa_da_ne;

@Value("${cac.gye.plazo}")
private Long plazo_cac_gye;

@Value("${cac.oc.plazo}")
private Long plazo_cac_oc;

@Value("${cac.multa.ft}")
private Long multa_cac_ft;

@Value("${cac.multa.ne}")
private Long multa_cac_ne;

@Value("${plazo_maximo}")
private Long plazo_maximo;

@Value("${informationService}")
private String informationService;

@Value("${dataSource}")
private String dataSource;

@Value("${urlMEis}")
private String urlMEis;

public Long getPlazo_da_gye() {
	return plazo_da_gye;
}

public void setPlazo_da_gye(Long plazo_da_gye) {
	this.plazo_da_gye = plazo_da_gye;
}

public Long getPlazo_oc_da() {
	return plazo_oc_da;
}

public void setPlazo_oc_da(Long plazo_oc_da) {
	this.plazo_oc_da = plazo_oc_da;
}

public Long getMulta_da_ft() {
	return multa_da_ft;
}

public void setMulta_da_ft(Long multa_da_ft) {
	this.multa_da_ft = multa_da_ft;
}

public Long getMulta_da_ne() {
	return multa_da_ne;
}

public void setMulta_da_ne(Long multa_da_ne) {
	this.multa_da_ne = multa_da_ne;
}

public Long getPlazo_cac_gye() {
	return plazo_cac_gye;
}

public void setPlazo_cac_gye(Long plazo_cac_gye) {
	this.plazo_cac_gye = plazo_cac_gye;
}

public Long getPlazo_cac_oc() {
	return plazo_cac_oc;
}

public void setPlazo_cac_oc(Long plazo_cac_oc) {
	this.plazo_cac_oc = plazo_cac_oc;
}

public Long getMulta_cac_ft() {
	return multa_cac_ft;
}

public void setMulta_cac_ft(Long multa_cac_ft) {
	this.multa_cac_ft = multa_cac_ft;
}

public Long getMulta_cac_ne() {
	return multa_cac_ne;
}

public void setMulta_cac_ne(Long multa_cac_ne) {
	this.multa_cac_ne = multa_cac_ne;
}

public Long getPlazo_maximo() {
	return plazo_maximo;
}

public void setPlazo_maximo(Long plazo_maximo) {
	this.plazo_maximo = plazo_maximo;
}

public String getInformationService() {
	return this.informationService;
}

public String getDataSource() {
	return this.dataSource;
}

public void setInformationService(String informationService) {
	this.informationService = informationService;
}

public void setDataSource(String dataSource) {
	this.dataSource = dataSource;
}

public String getUrlMEis() {
	return this.urlMEis;
}

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

public void setUrlMEis(String urlMEis) {
	this.urlMEis = urlMEis;
}



}
