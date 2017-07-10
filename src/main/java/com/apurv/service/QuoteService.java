package com.apurv.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apurv.model.QuoteV1;
import com.apurv.model.QuoteV2;

@Service
public class QuoteService {
	
	private static String BASE_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/";
	private static String RANDOM_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/random";
	
	public QuoteV1 getSimpleQuote(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(RANDOM_SERVICE_URL, QuoteV1.class);
	}

	public QuoteV2 getDetailQuote(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(RANDOM_SERVICE_URL, QuoteV2.class);
	}
	
	public QuoteV1 getQuoteV1ById(String id){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(BASE_SERVICE_URL+id, QuoteV1.class);
	}
	
	public QuoteV2 getQuoteV2ById(String id){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(BASE_SERVICE_URL+id, QuoteV2.class);
	}
	
	
}
