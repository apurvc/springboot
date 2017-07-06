package com.apurv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apurv.model.QuoteV1;
import com.apurv.model.QuoteV2;
import com.apurv.service.QuoteService;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {

	@Autowired
	private QuoteService quoteService;

	@RequestMapping(method = RequestMethod.GET, value = "/random", produces = "application/vnd.example.app-v1+json")
	public QuoteV1 getQuote() {
		return quoteService.getSimpleQuote();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{quoteId}", produces = "application/vnd.example.app-v1+json")
	public QuoteV1 getQuoteById(@PathVariable("quoteId") String quoteId ) {
		return quoteService.getQuoteV1ById(quoteId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/random", produces = "application/vnd.example.app-v2+json")
	public QuoteV2 getDetailQuote() {
		return quoteService.getDetailQuote();
	}
	
	

}
