package thanhnv.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Material", schema = "dbo", catalog = "FabricEvaluation")
public class MaterialEntity {
    private String fiber;
    private String uses;
    private String appearance;
    private String pros;
    private String cons;
    private String carewash;
    private String wrinkle;
    private String shrink;

    @Id
    @Column(name = "fiber", nullable = false, length = 100)
    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    @Basic
    @Column(name = "uses", nullable = true, length = 2147483647)
    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    @Basic
    @Column(name = "appearance", nullable = true, length = 2147483647)
    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    @Basic
    @Column(name = "pros", nullable = true, length = 2147483647)
    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    @Basic
    @Column(name = "cons", nullable = true, length = 2147483647)
    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    @Basic
    @Column(name = "carewash", nullable = true, length = 2147483647)
    public String getCarewash() {
        return carewash;
    }

    public void setCarewash(String carewash) {
        this.carewash = carewash;
    }

    @Basic
    @Column(name = "wrinkle", nullable = true, length = 2147483647)
    public String getWrinkle() {
        return wrinkle;
    }

    public void setWrinkle(String wrinkle) {
        this.wrinkle = wrinkle;
    }

    @Basic
    @Column(name = "shrink", nullable = true, length = 2147483647)
    public String getShrink() {
        return shrink;
    }

    public void setShrink(String shrink) {
        this.shrink = shrink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialEntity that = (MaterialEntity) o;
        return Objects.equals(fiber, that.fiber) &&
                Objects.equals(uses, that.uses) &&
                Objects.equals(appearance, that.appearance) &&
                Objects.equals(pros, that.pros) &&
                Objects.equals(cons, that.cons) &&
                Objects.equals(carewash, that.carewash) &&
                Objects.equals(wrinkle, that.wrinkle) &&
                Objects.equals(shrink, that.shrink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fiber, uses, appearance, pros, cons, carewash, wrinkle, shrink);
    }
}
