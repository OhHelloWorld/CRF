package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class MedicineLiverHospitalAbnormalExaminationCruorDTO {

    private int id;
    private int HospitalAbnormalExaminationId;
    private String pt;
    private String inr;
    private Date tab4CheckDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospitalAbnormalExaminationId() {
        return HospitalAbnormalExaminationId;
    }

    public void setHospitalAbnormalExaminationId(int hospitalAbnormalExaminationId) {
        HospitalAbnormalExaminationId = hospitalAbnormalExaminationId;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getInr() {
        return inr;
    }

    public void setInr(String inr) {
        this.inr = inr;
    }

    public Date getTab4CheckDate() {
        return tab4CheckDate;
    }

    public void setTab4CheckDate(Date tab4CheckDate) {
        this.tab4CheckDate = tab4CheckDate;
    }
}
