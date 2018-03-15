package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Entity(name = "medicine_liver_hospital_abnormal_examination_bs")
public class MedicineLiverHospitalAbnormalExaminationBsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_abnormal_examination_id")
    private MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO;
    private String plasmaGlucose;
    @Column(name = "tab3_check_date")
    private Date tab3CheckDate;

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
