package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Entity(name = "medicine_liver_hospital_abnormal_examination_cruor")
public class MedicineLiverHospitalAbnormalExaminationCruorDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_abnormal_examination_id")
    private MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO;
    private String pt;
    private String inr;
    @Column(name = "tab4_check_date")
    private Date tab4CheckDate;

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
