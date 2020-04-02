package pl.javaleader.java.dsl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

class ProcessFiles implements Processor {
    public void process(Exchange exchange) throws Exception {
        String originalFileName = (String) exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        exchange.getIn().setHeader(Exchange.FILE_NAME, originalFileName);
    }
}