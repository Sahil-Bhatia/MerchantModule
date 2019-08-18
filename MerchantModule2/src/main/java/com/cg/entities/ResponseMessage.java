package com.cg.entities;

import java.util.List;

public class ResponseMessage {
	
	String message;
	Integer statusCode;
	List<Merchant> merchantsList;
	Merchant merchantObject;
	public ResponseMessage() {
		// TODO Auto-generated constructor stub
	}
	public ResponseMessage(String message, Integer statusCode, List<Merchant> accountList, Merchant merchantObject) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.merchantsList = accountList;
		this.merchantObject = merchantObject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public Merchant getMerchantObject() {
		return merchantObject;
	}
	public void setMerchantObject(Merchant merchantObject) {
		this.merchantObject = merchantObject;
	}
	public List<Merchant> getMerchantsList() {
		return merchantsList;
	}
	public void setMerchantsList(List<Merchant> merchantsList) {
		this.merchantsList = merchantsList;
	}
	
	
}
