package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class MedicineLiverHospitalAbnormalExaminationKidneyDTO {

    private int id;
    private int hospitalAbnormalExaminationId;
    private String scr;
    private String ureaNitrogen;
    private Date tab2CheckDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospitalAbnormalExaminationId() {
        return hospitalAbnormalExaminationId;
    }

    public void setHospitalAbnormalExaminationId(int hospitalAbnormalExaminationId) {
        this.hospitalAbnormalExaminationId = hospitalAbnormalExaminationId;
    }

    public String getScr() {
        return scr;
    }

    public void setScr(String scr) {
        this.scr = scr;
    }

    public String getUreaNitrogen() {
        return ureaNitrogen;
    }

    public void setUreaNitrogen(String ureaNitrogen) {
        this.ureaNitrogen = ureaNitrogen;
    }

    public Date getTab2CheckDate() {
        return tab2CheckDate;
    }

    public void setTab2CheckDate(Date tab2CheckDate) {
        this.tab2CheckDate = tab2CheckDate;
    }
}
