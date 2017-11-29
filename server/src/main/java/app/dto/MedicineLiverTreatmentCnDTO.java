package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
public class MedicineLiverTreatmentCnDTO {

    private String cnTradeName;
    private String cnMethod;
    private String cnDose;
    private Date cnStartDate;
    private Date cnEndDate;

    public String getCnTradeName() {
        return cnTradeName;
    }

    public void setCnTradeName(String cnTradeName) {
        this.cnTradeName = cnTradeName;
    }

    public String getCnMethod() {
        return cnMethod;
    }

    public void setCnMethod(String cnMethod) {
        this.cnMethod = cnMethod;
    }

    public String getCnDose() {
        return cnDose;
    }

    public void setCnDose(String cnDose) {
        this.cnDose = cnDose;
    }

    public Date getCnStartDate() {
        return cnStartDate;
    }

    public void setCnStartDate(Date cnStartDate) {
        this.cnStartDate = cnStartDate;
    }

    public Date getCnEndDate() {
        return cnEndDate;
    }

    public void setCnEndDate(Date cnEndDate) {
        this.cnEndDate = cnEndDate;
    }
}
