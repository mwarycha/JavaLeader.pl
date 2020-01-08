
package pl.javaleader.ws;

import pl.javaleader.ws.services.Addidtion;
import pl.javaleader.ws.services.AddidtionResponse;
import pl.javaleader.ws.services.Subtraction;
import pl.javaleader.ws.services.SubtractionResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.javaleader.ws package. 
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

    private final static QName _SubtractionResponse_QNAME = new QName("http://ws.javaleader.pl/", "subtractionResponse");
    private final static QName _Subtraction_QNAME = new QName("http://ws.javaleader.pl/", "subtraction");
    private final static QName _Addidtion_QNAME = new QName("http://ws.javaleader.pl/", "addidtion");
    private final static QName _AddidtionResponse_QNAME = new QName("http://ws.javaleader.pl/", "addidtionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.javaleader.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddidtionResponse }
     * 
     */
    public AddidtionResponse createAddidtionResponse() {
        return new AddidtionResponse();
    }

    /**
     * Create an instance of {@link SubtractionResponse }
     * 
     */
    public SubtractionResponse createSubtractionResponse() {
        return new SubtractionResponse();
    }

    /**
     * Create an instance of {@link Subtraction }
     * 
     */
    public Subtraction createSubtraction() {
        return new Subtraction();
    }

    /**
     * Create an instance of {@link Addidtion }
     * 
     */
    public Addidtion createAddidtion() {
        return new Addidtion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.javaleader.pl/", name = "subtractionResponse")
    public JAXBElement<SubtractionResponse> createSubtractionResponse(SubtractionResponse value) {
        return new JAXBElement<SubtractionResponse>(_SubtractionResponse_QNAME, SubtractionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subtraction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.javaleader.pl/", name = "subtraction")
    public JAXBElement<Subtraction> createSubtraction(Subtraction value) {
        return new JAXBElement<Subtraction>(_Subtraction_QNAME, Subtraction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addidtion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.javaleader.pl/", name = "addidtion")
    public JAXBElement<Addidtion> createAddidtion(Addidtion value) {
        return new JAXBElement<Addidtion>(_Addidtion_QNAME, Addidtion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddidtionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.javaleader.pl/", name = "addidtionResponse")
    public JAXBElement<AddidtionResponse> createAddidtionResponse(AddidtionResponse value) {
        return new JAXBElement<AddidtionResponse>(_AddidtionResponse_QNAME, AddidtionResponse.class, null, value);
    }

}
