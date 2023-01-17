
package client_async;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for hall complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hall">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="movieName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="movieShowDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="placesCost" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="placesNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reservedPlaces" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hall", propOrder = {
    "movieName",
    "movieShowDate",
    "placesCost",
    "placesNum",
    "reservedPlaces"
})
public class Hall {

    protected String movieName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar movieShowDate;
    @XmlElement(nillable = true)
    protected List<Integer> placesCost;
    protected int placesNum;
    @XmlElement(nillable = true)
    protected List<Boolean> reservedPlaces;

    /**
     * Gets the value of the movieName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Sets the value of the movieName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieName(String value) {
        this.movieName = value;
    }

    /**
     * Gets the value of the movieShowDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMovieShowDate() {
        return movieShowDate;
    }

    /**
     * Sets the value of the movieShowDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMovieShowDate(XMLGregorianCalendar value) {
        this.movieShowDate = value;
    }

    /**
     * Gets the value of the placesCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the placesCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlacesCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPlacesCost() {
        if (placesCost == null) {
            placesCost = new ArrayList<Integer>();
        }
        return this.placesCost;
    }

    /**
     * Gets the value of the placesNum property.
     * 
     */
    public int getPlacesNum() {
        return placesNum;
    }

    /**
     * Sets the value of the placesNum property.
     * 
     */
    public void setPlacesNum(int value) {
        this.placesNum = value;
    }

    /**
     * Gets the value of the reservedPlaces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservedPlaces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservedPlaces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     * 
     * 
     */
    public List<Boolean> getReservedPlaces() {
        if (reservedPlaces == null) {
            reservedPlaces = new ArrayList<Boolean>();
        }
        return this.reservedPlaces;
    }

}
