package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class MlProprietaryChineseMedicineDTO {

    private int id;
    private int mlDrugId;
    private String proName;
    private String proManufactor;
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

    public int getMlDrugId() {
        return mlDrugId;
    }

    public void setMlDrugId(int mlDrugId) {
        this.mlDrugId = mlDrugId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProManufactor() {
        return proManufactor;
    }

    public void setProManufactor(String proManufactor) {
        this.proManufactor = proManufactor;
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
