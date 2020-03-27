package thanhnv.jaxb;

import java.io.Serializable;

public class Analysis implements Serializable {
    private String fabridName;
    private int percent;

    public Analysis() {
    }

    public Analysis(String fabridName, int percent) {
        this.fabridName = fabridName;
        this.percent = percent;
    }

    public String getFabridName() {
        return fabridName;
    }

    public void setFabridName(String fabridName) {
        this.fabridName = fabridName;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
