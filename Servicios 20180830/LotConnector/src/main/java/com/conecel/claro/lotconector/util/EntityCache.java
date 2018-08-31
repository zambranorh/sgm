package com.conecel.claro.lotconector.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 

public class EntityCache<T> implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private   List<T> results = new ArrayList<>();	
	private   T result;
	

	 
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	
}
