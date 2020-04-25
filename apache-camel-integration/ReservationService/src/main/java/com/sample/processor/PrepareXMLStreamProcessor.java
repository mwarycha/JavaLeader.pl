package com.sample.processor;

import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;


/**
 * Preparing the XML Stream of the in-bound Request Body to be consumed by the Camel XSLT component.
 */

public class PrepareXMLStreamProcessor implements Processor {
	
	/**
	 * To get the Logger instance for log message.
	 */
	private static final Logger LOGGER = Logger.getLogger(PrepareXMLStreamProcessor.class);
	
	
	/**
	 * Prepare XMl Stream of the in-bound request.
	 * 
	 * @param exchange
	 * 
	 */
	@Override
	public void process(Exchange exchange) throws Exception {

		LOGGER.debug("PrepareXMLStreamProcessor::process()::enters");
		
		String requestXML = exchange.getIn().getBody(String.class);
		
		StringReader stringReader = new StringReader(requestXML);

		StreamSource streamSource = new StreamSource(stringReader);

		exchange.getIn().setBody(streamSource);

		LOGGER.debug("PrepareXMLStreamProcessor::process()::exits");
	}
}