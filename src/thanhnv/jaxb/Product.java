
package thanhnv.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productimage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sizes" type="{https://www.uniqlo.com}sizes"/>
 *         &lt;element name="productinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", namespace = "https://www.uniqlo.com", propOrder = {
    "productid",
    "productname",
    "productimage",
    "price",
    "sizes",
    "productinfo",
    "material"
})
@XmlRootElement(name = "product",namespace = "https://www.uniqlo.com")
public class Product {

    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected String productid;
    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected String productname;
    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected String productimage;
    @XmlElement(namespace = "https://www.uniqlo.com")
    protected double price;
    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected Sizes sizes;
    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected String productinfo;
    @XmlElement(namespace = "https://www.uniqlo.com", required = true)
    protected String material;

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductid() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductid(String value) {
        this.productid = value;
    }

    /**
     * Gets the value of the productname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductname() {
        return productname;
    }

    /**
     * Sets the value of the productname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductname(String value) {
        this.productname = value;
    }

    /**
     * Gets the value of the productimage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductimage() {
        return productimage;
    }

    /**
     * Sets the value of the productimage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductimage(String value) {
        this.productimage = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the sizes property.
     * 
     * @return
     *     possible object is
     *     {@link Sizes }
     *     
     */
    public Sizes getSizes() {
        return sizes;
    }

    /**
     * Sets the value of the sizes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sizes }
     *     
     */
    public void setSizes(Sizes value) {
        this.sizes = value;
    }

    /**
     * Gets the value of the productinfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductinfo() {
        return productinfo;
    }

    /**
     * Sets the value of the productinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductinfo(String value) {
        this.productinfo = value;
    }

    /**
     * Gets the value of the material property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the value of the material property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaterial(String value) {
        this.material = value;
    }

}
