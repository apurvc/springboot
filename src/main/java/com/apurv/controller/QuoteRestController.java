package com.apurv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apurv.model.QuoteV1;
import com.apurv.model.QuoteV2;
import com.apurv.service.QuoteService;

import exception.QuoteNotFoundException;

@RestController
@RequestMapping("/api/quote")
public class QuoteRestController {

	@Autowired
	private QuoteService quoteService;

	@RequestMapping(method = RequestMethod.GET, value = "/random", consumes = "application/vnd.example.app-v1+json", produces = "application/vnd.example.app-v1+json")
	public QuoteV1 getQuote() {
		return quoteService.getSimpleQuote();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fixed/{quoteId}", consumes = "application/vnd.example.app-v1+json", produces = "application/vnd.example.app-v1+json")
	public QuoteV1 getQuoteById(@PathVariable("quoteId") String quoteId) {
		QuoteV1 quote = quoteService.getQuoteV1ById(quoteId);
		if(quote.getValue().getId()== null){
			throw new QuoteNotFoundException();
		}
		return quote;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/random", consumes = "application/vnd.example.app-v2+json", produces = "application/vnd.example.app-v2+json")
	public QuoteV2 getDetailQuote() {
		return quoteService.getDetailQuote();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fixed/{quoteId}", consumes = "application/vnd.example.app-v2+json", produces = "application/vnd.example.app-v2+json")
	public QuoteV2 getDetailQuoteById(@PathVariable("quoteId") String quoteId) {
		QuoteV2 quote = quoteService.getQuoteV2ById(quoteId);
		if(!quote.getType().equals("success")){
			throw new QuoteNotFoundException();
		}
		return quote;
	}

}
