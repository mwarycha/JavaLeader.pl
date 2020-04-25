package com.sample.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 * Aggregating the multicast response
 * 
 */
public class AggregateResponse implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

		Exception exception = (Exception) newExchange
				.getProperty(Exchange.EXCEPTION_CAUGHT);
		if (exception == null) {

			if (oldExchange == null && newExchange != null) {

				return newExchange;

			} else if (oldExchange != null && newExchange != null) {
				newExchange.getIn().setBody(
						oldExchange.getIn().getBody(String.class)
								+ newExchange.getIn().getBody(String.class));
			}
			return newExchange;
		}

		return oldExchange;

	}

}
