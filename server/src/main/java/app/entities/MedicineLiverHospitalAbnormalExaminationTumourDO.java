package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Entity(name = "medicine_liver_hospital_abnormal_examination_tumour")
public class MedicineLiverHospitalAbnormalExaminationTumourDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_abnormal_examination_id")
    private MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO;
    private String afp;
    @Column(name = "tab5_check_date")
    private Date tab5CheckDate;

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
