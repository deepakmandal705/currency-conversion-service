package com.deepak.currencyconversionservice.bean;

import java.math.BigDecimal;

public class ConversionValue {

	private int id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal conversionAmount;
	private int port;
	
	public ConversionValue() {
		
	}

	public ConversionValue(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal conversionAmount, int port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.conversionAmount = conversionAmount;
		this.port = port;
	}
	
	//setters and getters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConversionAmount() {
		return conversionAmount;
	}

	public void setConversionAmount(BigDecimal conversionAmount) {
		this.conversionAmount = conversionAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
