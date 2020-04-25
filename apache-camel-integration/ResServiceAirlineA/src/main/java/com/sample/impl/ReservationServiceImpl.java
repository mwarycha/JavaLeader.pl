package com.sample.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.sample.aira.quote.*;


@WebService(targetNamespace = "http://aira.sample.com/quote/", name = "AirLineAQuoteService", serviceName="AirLineAQuoteService", portName="AirLineQuoteSOAP")
public class ReservationServiceImpl implements AirLineAQuote{
	
	 public GetQuoteResponse getQuoteOperation(GetQuote parameters){
		 GetQuoteResponse getQuoteResponse = new GetQuoteResponse();
		 GetQuoteResp getQuoteResp = new GetQuoteResp();
		 Quote quote = new Quote();
		 quote.setAirLine("INDIGO");
		 quote.setPrice("4000");
		 getQuoteResp.setPrice(quote);
		 getQuoteResponse.setGetQuoteResponse(getQuoteResp);
		 return getQuoteResponse;
	 }

}
