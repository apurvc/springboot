package com.apurv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apurv.model.QuoteV1;
import com.apurv.model.QuoteV2;
import com.apurv.service.QuoteService;

@Controller
public class QuoteWebController {

	@Autowired
	private QuoteService quoteService;
	
	@GetMapping
	public String home(){
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/random")
	public String getQuote(Model model) {
		model.addAttribute("quote", quoteService.getSimpleQuote());
		return "randomquote";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/fixedquote/{quoteId}")
	public String getQuoteById(Model model,@PathVariable("quoteId") String quoteId) {
		model.addAttribute("quote", quoteService.getSimpleQuote());
		return "fixedquote";
	}

}
