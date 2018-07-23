package com.conecel.claro.comissionconector.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comission {
  private Long amount;

public Long getAmount() {
	return amount;
}

public void setAmount(Long amount) {
	this.amount = amount;
}
  
  
}
