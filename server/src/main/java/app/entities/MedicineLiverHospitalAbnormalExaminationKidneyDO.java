package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Entity(name = "medicine_liver_hospital_abnormal_examination_kidney")
public class MedicineLiverHospitalAbnormalExaminationKidneyDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_abnormal_examination_id")
    private MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO;
    private String scr;
    private String ureaNitrogen;
    @Column(name = "tab2_check_date")
    private Date tab2CheckDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverHospitalAbnormalExaminationDO getMedicineLiverHospitalAbnormalExaminationDO() {
        return medicineLiverHospitalAbnormalExaminationDO;
    }

    public void setMedicineLiverHospitalAbnormalExaminationDO(MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO) {
        this.medicineLiverHospitalAbnormalExaminationDO = medicineLiverHospitalAbnormalExaminationDO;
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
