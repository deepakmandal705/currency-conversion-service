package com.deepak.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepak.currencyconversionservice.bean.ConversionValue;
import com.deepak.currencyconversionservice.services.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping(value = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionValue getCurrencyConversionValue(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<ConversionValue> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange-jpa/from/{from}/to/{to}",
				ConversionValue.class, uriVariables);
		
		ConversionValue response = responseEntity.getBody();
		
		return new ConversionValue(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@GetMapping(value = "currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionValue convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		ConversionValue response = proxy.retrieveExchangeValue(from, to);
		logger.info("{}", response);
		
		return new ConversionValue(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
}
