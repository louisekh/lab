
package client_async;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paycheck complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paycheck">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="checkPaid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paycheck", propOrder = {
    "checkCost",
    "checkPaid",
    "product"
})
public class Paycheck {

    protected int checkCost;
    protected Boolean checkPaid;
    protected String product;

    /**
     * Gets the value of the checkCost property.
     * 
     */
    public int getCheckCost() {
        return checkCost;
    }

    /**
     * Sets the value of the checkCost property.
     * 
     */
    public void setCheckCost(int value) {
        this.checkCost = value;
    }

    /**
     * Gets the value of the checkPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckPaid() {
        return checkPaid;
    }

    /**
     * Sets the value of the checkPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckPaid(Boolean value) {
        this.checkPaid = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

}
