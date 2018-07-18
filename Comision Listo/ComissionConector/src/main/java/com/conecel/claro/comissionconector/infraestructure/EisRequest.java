package com.conecel.claro.comissionconector.infraestructure;

import java.util.List;

public class EisRequest
{
    private List<Inputs> inputs;

    private String source;

    private String informationService;

     

    public List<Inputs> getInputs() {
		return inputs;
	}



	public void setInputs(List<Inputs> inputs) {
		this.inputs = inputs;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getInformationService() {
		return informationService;
	}



	public void setInformationService(String informationService) {
		this.informationService = informationService;
	}



	@Override
    public String toString()
    {
        return "ClassPojo [inputs = "+inputs+", source = "+source+", informationService = "+informationService+"]";
    }
}