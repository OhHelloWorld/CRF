package app.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Entity(name = "ml_suspend_chinese_medicine")
public class MlSuspendChineseMedicineDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ml_drug_id")
    private MedicineLiverSuspectedDrugDO mlSuspectedDrugDO;
    private String susName;
    private String sample;
    private String number;
    private String susCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverSuspectedDrugDO getMlSuspectedDrugDO() {
        return mlSuspectedDrugDO;
    }

    public void setMlSuspectedDrugDO(MedicineLiverSuspectedDrugDO mlSuspectedDrugDO) {
        this.mlSuspectedDrugDO = mlSuspectedDrugDO;
    }

    public String getSusName() {
        return susName;
    }

    public void setSusName(String susName) {
        this.susName = susName;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSusCategory() {
        return susCategory;
    }

    public void setSusCategory(String susCategory) {
        this.susCategory = susCategory;
    }
}
