package com.apurv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class QuoteV1 {

    private Value value;

    public QuoteV1() {
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
}