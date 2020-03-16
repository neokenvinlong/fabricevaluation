
package thanhnv.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for material complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="material">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fiber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uses" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appearance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pros" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cons" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carewash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wrinkle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shrink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "material", namespace = "https://dressmann.com", propOrder = {
    "fiber",
    "uses",
    "appearance",
    "pros",
    "cons",
    "carewash",
    "wrinkle",
    "shrink"
})
public class Material {

    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String fiber;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String uses;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String appearance;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String pros;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String cons;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String carewash;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String wrinkle;
    @XmlElement(namespace = "https://dressmann.com", required = true)
    protected String shrink;

    /**
     * Gets the value of the fiber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiber() {
        return fiber;
    }

    /**
     * Sets the value of the fiber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiber(String value) {
        this.fiber = value;
    }

    /**
     * Gets the value of the uses property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUses() {
        return uses;
    }

    /**
     * Sets the value of the uses property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUses(String value) {
        this.uses = value;
    }

    /**
     * Gets the value of the appearance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppearance() {
        return appearance;
    }

    /**
     * Sets the value of the appearance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppearance(String value) {
        this.appearance = value;
    }

    /**
     * Gets the value of the pros property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPros() {
        return pros;
    }

    /**
     * Sets the value of the pros property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPros(String value) {
        this.pros = value;
    }

    /**
     * Gets the value of the cons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCons() {
        return cons;
    }

    /**
     * Sets the value of the cons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCons(String value) {
        this.cons = value;
    }

    /**
     * Gets the value of the carewash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarewash() {
        return carewash;
    }

    /**
     * Sets the value of the carewash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarewash(String value) {
        this.carewash = value;
    }

    /**
     * Gets the value of the wrinkle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrinkle() {
        return wrinkle;
    }

    /**
     * Sets the value of the wrinkle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrinkle(String value) {
        this.wrinkle = value;
    }

    /**
     * Gets the value of the shrink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShrink() {
        return shrink;
    }

    /**
     * Sets the value of the shrink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShrink(String value) {
        this.shrink = value;
    }

}
