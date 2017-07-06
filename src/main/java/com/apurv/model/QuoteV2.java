package com.apurv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteV2 {

	private String type;
    private Value value;

    public QuoteV2() {
    }


    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
        		"value=" + value +
                '}';
    }


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
}