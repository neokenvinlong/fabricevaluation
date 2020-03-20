package thanhnv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Product", schema = "dbo", catalog = "FabricEvaluation")
@NamedQueries(
        @NamedQuery(name = "ProductEntity.findByHashCode",
                query = "SELECT p.hashCode FROM ProductEntity p where p.hashCode = :hashCode")
)
public class ProductEntity {
    private String productId;
    private String productName;
    private String productImage;
    private Double productPrice;
    private String productSize;
    private String productInfo;
    private String material;
    private String hashCode;
    private CategoryEntity categoryByCategoryId;

    @Id
    @Column(name = "productId", nullable = false, length = 100)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productName", nullable = false, length = 2147483647)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productImage", nullable = true, length = 200)
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
    @Column(name = "productSize", nullable = true, length = 200)
    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    @Basic
    @Column(name = "productInfo", nullable = true, length = 2147483647)
    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    @Basic
    @Column(name = "material", nullable = true, length = 2147483647)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "hashCode", nullable = true, length = 2147483647)
    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity entity = (ProductEntity) o;
        return Objects.equals(productId, entity.productId) &&
                Objects.equals(productName, entity.productName) &&
                Objects.equals(productImage, entity.productImage) &&
                Objects.equals(productPrice, entity.productPrice) &&
                Objects.equals(productSize, entity.productSize) &&
                Objects.equals(productInfo, entity.productInfo) &&
                Objects.equals(material, entity.material) &&
                Objects.equals(hashCode, entity.hashCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productImage, productPrice, productSize, productInfo, material, hashCode);
    }

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
