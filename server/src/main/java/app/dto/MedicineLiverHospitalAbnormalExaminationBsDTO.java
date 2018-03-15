package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class MedicineLiverHospitalAbnormalExaminationBsDTO {

    private int id;
    private int hospitalAbnormalExaminationId;
    private String plasmaGlucose;
    private Date tab3CheckDate;

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

    public String getPlasmaGlucose() {
        return plasmaGlucose;
    }

    public void setPlasmaGlucose(String plasmaGlucose) {
        this.plasmaGlucose = plasmaGlucose;
    }

    public Date getTab3CheckDate() {
        return tab3CheckDate;
    }

    public void setTab3CheckDate(Date tab3CheckDate) {
        this.tab3CheckDate = tab3CheckDate;
    }
}
