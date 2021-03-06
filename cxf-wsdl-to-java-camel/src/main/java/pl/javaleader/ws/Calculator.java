package pl.javaleader.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2020-01-07T20:22:26.291+01:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://ws.javaleader.pl/", name = "Calculator")
@XmlSeeAlso({ObjectFactory.class})
public interface Calculator {

    @WebMethod
    @RequestWrapper(localName = "addidtion", targetNamespace = "http://ws.javaleader.pl/", className = "Addidtion")
    @ResponseWrapper(localName = "addidtionResponse", targetNamespace = "http://ws.javaleader.pl/", className = "AddidtionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int addidtion(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebMethod
    @RequestWrapper(localName = "subtraction", targetNamespace = "http://ws.javaleader.pl/", className = "Subtraction")
    @ResponseWrapper(localName = "subtractionResponse", targetNamespace = "http://ws.javaleader.pl/", className = "SubtractionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int subtraction(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );
}
