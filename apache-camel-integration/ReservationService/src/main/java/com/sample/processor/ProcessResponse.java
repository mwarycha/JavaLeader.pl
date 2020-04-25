package com.sample.processor;


import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;


/**
 * Preparing the XML Stream of the in-bound aggregated Response Body of the multicast route to be consumed by the Camel XSLT component.
 * 
 */
public class ProcessResponse implements Processor {
	
	private static final Logger LOGGER = Logger.getLogger(ProcessResponse.class);
	
	
	/**
	 * Preparing the XML Stream of the in-bound aggregated Response Body of the multicast route.
	 * 
	 * @param exchange
	 * 
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.debug("ProcessResponse::process()::enters");
		
		// Just adding the temp node this will be useful while transforming the response
		StringBuffer multicastResponseXML = new StringBuffer("<aggregatedResponse>\n");
		
		multicastResponseXML.append(exchange.getIn().getBody(String.class));
		
		// Just closing the temp node
		multicastResponseXML.append("\n </aggregatedResponse>");
		
		StringReader stringReader = new StringReader(multicastResponseXML.toString());

		StreamSource streamSource = new StreamSource(stringReader);

		exchange.getIn().setBody(streamSource);

		LOGGER.debug("ProcessResponse::process()::exits");
	}
}