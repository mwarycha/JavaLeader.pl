package com.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.sample.util.XPathReaderUtil;

/**
 * 
 * To validate the in-bound request.
 * 
 */

public class RequestValidator implements Processor {

	/**
	 * To get the Logger instance for log message.
	 */

	private static final Logger LOGGER = Logger
			.getLogger(RequestValidator.class);

	public static final String XPATH_ORIGIN = "//*[local-name() = 'source']";
	public static final String XPATH_DESTINATION = "//*[local-name() = 'destination']";
	public static final String XPATH_DATE = "//*[local-name() = 'date']";
	public static final String XPATH_AIRLINES = "//*[local-name() = 'airline']";

	/**
	 * Validating the request to make sure the Origin, Destination and Date are
	 * not empty.
	 * 
	 * @param exchange
	 * 
	 */

	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.debug("RequestValidator::process()::enters");

		String requestXML = exchange.getIn().getBody(String.class);

		XPathReaderUtil xpathReader = new XPathReaderUtil(requestXML);

		// Validating the Origin

		getNodeValue(exchange, xpathReader, XPATH_ORIGIN, "source");

		// Validating the Destination

		getNodeValue(exchange, xpathReader, XPATH_DESTINATION, "destination");

		// Validating the Date

		getNodeValue(exchange, xpathReader, XPATH_DATE, "date");

		// Validating the airLines

		getNodeValue(exchange, xpathReader, XPATH_AIRLINES, "airline");

		LOGGER.debug("RequestValidator::process()::exits");
	}

	private void getNodeValue(Exchange exchange, XPathReaderUtil xpathReader,
			String xpathName, String nodeName) throws Exception {

		String nodeValue = null;

		try {
			nodeValue = xpathReader.getNodeValue(xpathName);

			if ("".equals(nodeValue)) {
				throw (new Exception());
			}
			if ("airline".equals(nodeName)) {
				setAirLine(exchange, nodeValue);
			}

		} catch (Exception exception) {
			if ("source".equals(nodeName)) {
				throw (new Exception("Please provide Source - Starting place!"));
			} else if ("destination".equals(nodeName)) {
				throw (new Exception("Please provide Destination!"));
			} else if ("date".equals(nodeName)) {
				throw (new Exception("Please provide Travel date"));
			} else if ("airline".equals(nodeName)) {
				setAirLine(exchange, "All");
			}
		}
	}

	private void setAirLine(Exchange exchange, String airLines)
			throws Exception {
		if (airLines != null) {
			if ("AirLineA".equals(airLines) || "AirLineB".equals(airLines)
					|| "All".equals(airLines)) {
				exchange.getIn().setHeader("airLines", airLines);
			} else {
				exchange.getIn().setHeader("airLines", "NONE");
				throw (new Exception("Please provide valid Airline name or All"));
			}

		}

	}

}
