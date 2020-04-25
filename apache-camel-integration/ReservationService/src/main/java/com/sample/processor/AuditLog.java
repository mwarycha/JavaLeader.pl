package com.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.camel.component.cxf.CxfPayload;



import com.sample.util.XPathReaderUtil;

/**
 * 
 * To validate the in-bound request.
 * 
 */

public class AuditLog implements Processor {

	/**
	 * To get the Logger instance for log message.
	 */

	private static final Logger LOGGER = Logger
			.getLogger(AuditLog.class);

	/**
	 * Log the request .
	 * 
	 * @param exchange
	 * 
	 */

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.debug("AuditLog::process()::enters");


		CxfPayload<SoapHeader> requestPayload = exchange.getIn().getBody(CxfPayload.class);

		//Store the XML
		
		LOGGER.debug("AuditLog::process()::exits");
	}

	

}
