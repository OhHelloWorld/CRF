package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_suspected_drug_detail")
public class MedicineLiverSuspectedDrugDetailDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "medicine_liver_suspected_drug_id")
    private MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO;
    private String genericName;//通用名
    private String tradeName;//商品名
    private String drugClassification;//药物种类
    private String medicationMethod;//用药方法
    private String dose;//日剂量
    private Date beginDate;//开始日期
    @Column(name = "drug_with_drawal")
    private String drugWithDrawal;//是否停药
    @Column(name = "drug_with_drawal_date")
    private Date drugWithDrawalDate;//停药日期
    private String decrement;//是否减量
    private String drugExposure;//既往该药暴露史
    @Column(name = "exposure_liver_damage")
    private String exposureLiverDamage;//既往暴露引起肝损
    private String manufactor;//厂家及批号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverSuspectedDrugDO getMedicineLiverSuspectedDrugDO() {
        return medicineLiverSuspectedDrugDO;
    }

    public void setMedicineLiverSuspectedDrugDO(MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO) {
        this.medicineLiverSuspectedDrugDO = medicineLiverSuspectedDrugDO;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getTredeName() {
        return tradeName;
    }

    public void setTredeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getDrugClassification() {
        return drugClassification;
    }

    public void setDrugClassification(String drugClassification) {
        this.drugClassification = drugClassification;
    }

    public String getMedicationMethod() {
        return medicationMethod;
    }

    public void setMedicationMethod(String medicationMethod) {
        this.medicationMethod = medicationMethod;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getDrugWithDrawal() {
        return drugWithDrawal;
    }

    public void setDrugWithDrawal(String drugWithDrawal) {
        this.drugWithDrawal = drugWithDrawal;
    }

    public Date getDrugWithDrawalDate() {
        return drugWithDrawalDate;
    }

    public void setDrugWithDrawalDate(Date drugWithDrawalDate) {
        this.drugWithDrawalDate = drugWithDrawalDate;
    }

    public String getDecrement() {
        return decrement;
    }

    public void setDecrement(String decrement) {
        this.decrement = decrement;
    }

    public String getDrugExposure() {
        return drugExposure;
    }

    public void setDrugExposure(String drugExposure) {
        this.drugExposure = drugExposure;
    }

    public String getExposureLiverDamage() {
        return exposureLiverDamage;
    }

    public void setExposureLiverDamage(String exposureLiverDamage) {
        this.exposureLiverDamage = exposureLiverDamage;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }
}
