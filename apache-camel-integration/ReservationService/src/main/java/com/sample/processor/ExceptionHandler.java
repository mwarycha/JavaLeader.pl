package com.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

/**
 * Used to throw application exception.
 * 
 */

public class ExceptionHandler implements Processor {
	/**
	 * To get the Logger instance for log message.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ExceptionHandler.class);

	/**
	 * To Catch the exception triggered while routing
	 * 
	 * @param exchange
	 */
	
	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.debug("ExceptionHandler::process()::enters");

		Exception exception = (Exception) exchange
				.getProperty(Exchange.EXCEPTION_CAUGHT);
		
		if (exception instanceof org.apache.cxf.transport.http.HTTPException) {
			LOGGER.debug("ExceptionHandler::process()::exits");
			throw (new Exception("TargetService Not Available!"));
		} if (exception instanceof org.apache.cxf.interceptor.Fault){
			throw (new Exception("Unable to communicate with the Service!"));
			
		} else {
			throw (new Exception("unknown exception occured!"));
		}
		
		
		
	}

}

