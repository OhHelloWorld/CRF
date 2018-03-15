package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class MedicineLiverHospitalAbnormalExaminationTumourDTO {

    private int id;
    private int hospitalAbnormalExaminationId;
    private String afp;
    private Date tab5CheckDate;

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

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public Date getTab5CheckDate() {
        return tab5CheckDate;
    }

    public void setTab5CheckDate(Date tab5CheckDate) {
        this.tab5CheckDate = tab5CheckDate;
    }
}
