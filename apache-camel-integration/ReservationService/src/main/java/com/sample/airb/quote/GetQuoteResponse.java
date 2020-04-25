
package com.sample.airb.quote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getQuoteResponse" type="{http://airb.sample.com/quote/}getQuoteResp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getQuoteResponse"
})
@XmlRootElement(name = "getQuoteResponse")
public class GetQuoteResponse {

    @XmlElement(required = true)
    protected GetQuoteResp getQuoteResponse;

    /**
     * Gets the value of the getQuoteResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetQuoteResp }
     *     
     */
    public GetQuoteResp getGetQuoteResponse() {
        return getQuoteResponse;
    }

    /**
     * Sets the value of the getQuoteResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQuoteResp }
     *     
     */
    public void setGetQuoteResponse(GetQuoteResp value) {
        this.getQuoteResponse = value;
    }

}
