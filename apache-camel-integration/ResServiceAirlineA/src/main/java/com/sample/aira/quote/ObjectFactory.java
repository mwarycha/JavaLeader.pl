
package com.sample.aira.quote;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sample.aira.quote package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sample.aira.quote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuoteFault }
     * 
     */
    public GetQuoteFault createGetQuoteFault() {
        return new GetQuoteFault();
    }

    /**
     * Create an instance of {@link GetQuote }
     * 
     */
    public GetQuote createGetQuote() {
        return new GetQuote();
    }

    /**
     * Create an instance of {@link Quote }
     * 
     */
    public Quote createQuote() {
        return new Quote();
    }

    /**
     * Create an instance of {@link GetQuoteRequest }
     * 
     */
    public GetQuoteRequest createGetQuoteRequest() {
        return new GetQuoteRequest();
    }

    /**
     * Create an instance of {@link GetQuoteResponse }
     * 
     */
    public GetQuoteResponse createGetQuoteResponse() {
        return new GetQuoteResponse();
    }

    /**
     * Create an instance of {@link GetQuoteResp }
     * 
     */
    public GetQuoteResp createGetQuoteResp() {
        return new GetQuoteResp();
    }

}
