package com.sample.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.sample.airb.quote.*;


@WebService(targetNamespace = "http://airb.sample.com/quote/", name = "AirLineBQuoteService", serviceName="AirLineBQuoteService", portName="AirLineQuoteSOAP")
public class ReservationServiceImpl implements AirLineBQuote{
	
	 public GetQuoteResponse getQuoteOperation(GetQuote parameters){
		 GetQuoteResponse getQuoteResponse = new GetQuoteResponse();
		 GetQuoteResp getQuoteResp = new GetQuoteResp();
		 Quote quote = new Quote();
		 quote.setAirLine("SPICEJET");
		 quote.setPrice("4500");
		 getQuoteResp.setPrice(quote);
		 getQuoteResponse.setGetQuoteResponse(getQuoteResp);
		 return getQuoteResponse;
	 }

}
