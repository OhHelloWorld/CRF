package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverSuspectedDrugDetailDTO {
    private int id;
    private int medicineLiverSuspectedDrugId;
    private String genericName;//通用名
    private String tradeName;//商品名
    private String treatComplaint;//治疗疾病
    private String medication_method;//用药方法
    private String dose;//日剂量
    private Date beginDate;//开始日期
    private int drugWithdrawal;//是否停药
    private Date drugWithdrawalDate;//停药日期
    private int decrement;//是否减量
    private int drugExposure;//既往该药暴露史
    private int exposureLiverDamage;//既往暴露引起肝损

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicineLiverSuspectedDrugId() {
        return medicineLiverSuspectedDrugId;
    }

    public void setMedicineLiverSuspectedDrugId(int medicineLiverSuspectedDrugId) {
        this.medicineLiverSuspectedDrugId = medicineLiverSuspectedDrugId;
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

    public String getTreatComplaint() {
        return treatComplaint;
    }

    public void setTreatComplaint(String treatComplaint) {
        this.treatComplaint = treatComplaint;
    }

    public String getMedication_method() {
        return medication_method;
    }

    public void setMedication_method(String medication_method) {
        this.medication_method = medication_method;
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

    public int getDrugWithdrawal() {
        return drugWithdrawal;
    }

    public void setDrugWithdrawal(int drugWithdrawal) {
        this.drugWithdrawal = drugWithdrawal;
    }

    public Date getDrugWithdrawalDate() {
        return drugWithdrawalDate;
    }

    public void setDrugWithdrawalDate(Date drugWithdrawalDate) {
        this.drugWithdrawalDate = drugWithdrawalDate;
    }

    public int getDecrement() {
        return decrement;
    }

    public void setDecrement(int decrement) {
        this.decrement = decrement;
    }

    public int getDrugExposure() {
        return drugExposure;
    }

    public void setDrugExposure(int drugExposure) {
        this.drugExposure = drugExposure;
    }

    public int getExposureLiverDamage() {
        return exposureLiverDamage;
    }

    public void setExposureLiverDamage(int exposureLiverDamage) {
        this.exposureLiverDamage = exposureLiverDamage;
    }
}
