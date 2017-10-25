package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Entity(name = "ml_chinese_herbal_medicine")
public class MlChineseHerbalMedicineDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="ml_drug_id")
    private MedicineLiverSuspectedDrugDO mlSuspectedDrugDO;
    private String herbalName;
    private String herbalDose;
    @Column(name = "herbal_begin_time")
    private Date herbalBeginTime;
    @Column(name = "herbal_end_time")
    private Date herbalEndTime;
    private String buyFrom;
    private String herbalCategory;

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

    public String getHerbalName() {
        return herbalName;
    }

    public void setHerbalName(String herbalName) {
        this.herbalName = herbalName;
    }

    public String getHerbalDose() {
        return herbalDose;
    }

    public void setHerbalDose(String herbalDose) {
        this.herbalDose = herbalDose;
    }

    public Date getHerbalBeginTime() {
        return herbalBeginTime;
    }

    public void setHerbalBeginTime(Date herbalBeginTime) {
        this.herbalBeginTime = herbalBeginTime;
    }

    public Date getHerbalEndTime() {
        return herbalEndTime;
    }

    public void setHerbalEndTime(Date herbalEndTime) {
        this.herbalEndTime = herbalEndTime;
    }

    public String getBuyFrom() {
        return buyFrom;
    }

    public void setBuyFrom(String buyFrom) {
        this.buyFrom = buyFrom;
    }

    public String getHerbalCategory() {
        return herbalCategory;
    }

    public void setHerbalCategory(String herbalCategory) {
        this.herbalCategory = herbalCategory;
    }
}
