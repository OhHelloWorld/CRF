package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Entity(name = "ml_proprietary_chinese_medicine")
public class MlProprietaryChineseMedicineDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="ml_drug_id")
    private MedicineLiverSuspectedDrugDO mlSuspectedDrugDO;
    private String proName;
    private String manufactor;
    private String constitute;
    private String suspendConstitute;
    private String proDose;
    private Date proBeginTime;
    private Date proEndTime;
    private String proCategory;

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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getConstitute() {
        return constitute;
    }

    public void setConstitute(String constitute) {
        this.constitute = constitute;
    }

    public String getSuspendConstitute() {
        return suspendConstitute;
    }

    public void setSuspendConstitute(String suspendConstitute) {
        this.suspendConstitute = suspendConstitute;
    }

    public String getProDose() {
        return proDose;
    }

    public void setProDose(String proDose) {
        this.proDose = proDose;
    }

    public Date getProBeginTime() {
        return proBeginTime;
    }

    public void setProBeginTime(Date proBeginTime) {
        this.proBeginTime = proBeginTime;
    }

    public Date getProEndTime() {
        return proEndTime;
    }

    public void setProEndTime(Date proEndTime) {
        this.proEndTime = proEndTime;
    }

    public String getProCategory() {
        return proCategory;
    }

    public void setProCategory(String proCategory) {
        this.proCategory = proCategory;
    }
}
