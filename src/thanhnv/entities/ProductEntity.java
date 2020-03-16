package thanhnv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "dbo", catalog = "FabricEvaluation")
public class ProductEntity {
    private String productId;
    private String productName;
    private String productImage;
    private Double productPrice;
    private String productInfo;
    private String material;
    private int sizeId;

    @Id
    @Column(name = "productId", nullable = false, length = 50)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productName", nullable = true, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productImage", nullable = true, length = 50)
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Basic
    @Column(name = "productPrice", nullable = true, precision = 0)
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "productInfo", nullable = true, length = 100)
    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    @Basic
    @Column(name = "material", nullable = true, length = 100)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "sizeId", nullable = false)
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return sizeId == that.sizeId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productImage, that.productImage) &&
                Objects.equals(productPrice, that.productPrice) &&
                Objects.equals(productInfo, that.productInfo) &&
                Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productImage, productPrice, productInfo, material, sizeId);
    }
}
