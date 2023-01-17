
package client_async;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client_async package. 
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

    private final static QName _CheckPay_QNAME = new QName("http://service/", "CheckPay");
    private final static QName _CheckPayResponse_QNAME = new QName("http://service/", "CheckPayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client_async
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckPayResponse }
     * 
     */
    public CheckPayResponse createCheckPayResponse() {
        return new CheckPayResponse();
    }

    /**
     * Create an instance of {@link CheckPay }
     * 
     */
    public CheckPay createCheckPay() {
        return new CheckPay();
    }

    /**
     * Create an instance of {@link Hall }
     * 
     */
    public Hall createHall() {
        return new Hall();
    }

    /**
     * Create an instance of {@link Paycheck }
     * 
     */
    public Paycheck createPaycheck() {
        return new Paycheck();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "CheckPay")
    public JAXBElement<CheckPay> createCheckPay(CheckPay value) {
        return new JAXBElement<CheckPay>(_CheckPay_QNAME, CheckPay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "CheckPayResponse")
    public JAXBElement<CheckPayResponse> createCheckPayResponse(CheckPayResponse value) {
        return new JAXBElement<CheckPayResponse>(_CheckPayResponse_QNAME, CheckPayResponse.class, null, value);
    }

}
