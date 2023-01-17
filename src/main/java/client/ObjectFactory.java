
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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

    private final static QName _ReservePlaceResponse_QNAME = new QName("http://service/", "ReservePlaceResponse");
    private final static QName _ReservePlace_QNAME = new QName("http://service/", "ReservePlace");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReservePlaceResponse }
     * 
     */
    public ReservePlaceResponse createReservePlaceResponse() {
        return new ReservePlaceResponse();
    }

    /**
     * Create an instance of {@link ReservePlace }
     * 
     */
    public ReservePlace createReservePlace() {
        return new ReservePlace();
    }

    /**
     * Create an instance of {@link Hall }
     * 
     */
    public Hall createHall() {
        return new Hall();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservePlaceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ReservePlaceResponse")
    public JAXBElement<ReservePlaceResponse> createReservePlaceResponse(ReservePlaceResponse value) {
        return new JAXBElement<ReservePlaceResponse>(_ReservePlaceResponse_QNAME, ReservePlaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservePlace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "ReservePlace")
    public JAXBElement<ReservePlace> createReservePlace(ReservePlace value) {
        return new JAXBElement<ReservePlace>(_ReservePlace_QNAME, ReservePlace.class, null, value);
    }

}
