package thanhnv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Analysis", schema = "dbo", catalog = "FabricEvaluation")
public class AnalysisEntity {
    private int anaId;
    private Integer percentage;
    private String fabridName;
    private ProductEntity productByProductId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "anaId", nullable = false)
    public int getAnaId() {
        return anaId;
    }

    public void setAnaId(int anaId) {
        this.anaId = anaId;
    }

    @Basic
    @Column(name = "percentage", nullable = true)
    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Basic
    @Column(name = "fabridName", nullable = true, length = 100)
    public String getFabridName() {
        return fabridName;
    }

    public void setFabridName(String fabridName) {
        this.fabridName = fabridName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisEntity that = (AnalysisEntity) o;
        return anaId == that.anaId &&
                Objects.equals(percentage, that.percentage) &&
                Objects.equals(fabridName, that.fabridName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anaId, percentage, fabridName);
    }

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }
}
