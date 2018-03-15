package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_hospital_abnormal_examination")
public class MedicineLiverHospitalAbnormalExaminationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    @OneToMany(mappedBy = "medicineLiverHospitalAbnormalExaminationDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverHospitalAbnormalExaminationLiverDO> medicineLiverHospitalAbnormalExaminationLiverDOS;
    @OneToMany(mappedBy = "medicineLiverHospitalAbnormalExaminationDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverHospitalAbnormalExaminationKidneyDO> medicineLiverHospitalAbnormalExaminationKidneyDOS;
    @OneToMany(mappedBy = "medicineLiverHospitalAbnormalExaminationDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverHospitalAbnormalExaminationBsDO> medicineLiverHospitalAbnormalExaminationBsDOS;
    @OneToMany(mappedBy = "medicineLiverHospitalAbnormalExaminationDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverHospitalAbnormalExaminationCruorDO> medicineLiverHospitalAbnormalExaminationCruorDOS;
    @OneToMany(mappedBy = "medicineLiverHospitalAbnormalExaminationDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverHospitalAbnormalExaminationTumourDO> medicineLiverHospitalAbnormalExaminationTumourDOS;

    private Boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<MedicineLiverHospitalAbnormalExaminationLiverDO> getMedicineLiverHospitalAbnormalExaminationLiverDOS() {
        return medicineLiverHospitalAbnormalExaminationLiverDOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationLiverDOS(List<MedicineLiverHospitalAbnormalExaminationLiverDO> medicineLiverHospitalAbnormalExaminationLiverDOS) {
        this.medicineLiverHospitalAbnormalExaminationLiverDOS = medicineLiverHospitalAbnormalExaminationLiverDOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationKidneyDO> getMedicineLiverHospitalAbnormalExaminationKidneyDOS() {
        return medicineLiverHospitalAbnormalExaminationKidneyDOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationKidneyDOS(List<MedicineLiverHospitalAbnormalExaminationKidneyDO> medicineLiverHospitalAbnormalExaminationKidneyDOS) {
        this.medicineLiverHospitalAbnormalExaminationKidneyDOS = medicineLiverHospitalAbnormalExaminationKidneyDOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationBsDO> getMedicineLiverHospitalAbnormalExaminationBsDOS() {
        return medicineLiverHospitalAbnormalExaminationBsDOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationBsDOS(List<MedicineLiverHospitalAbnormalExaminationBsDO> medicineLiverHospitalAbnormalExaminationBsDOS) {
        this.medicineLiverHospitalAbnormalExaminationBsDOS = medicineLiverHospitalAbnormalExaminationBsDOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationCruorDO> getMedicineLiverHospitalAbnormalExaminationCruorDOS() {
        return medicineLiverHospitalAbnormalExaminationCruorDOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationCruorDOS(List<MedicineLiverHospitalAbnormalExaminationCruorDO> medicineLiverHospitalAbnormalExaminationCruorDOS) {
        this.medicineLiverHospitalAbnormalExaminationCruorDOS = medicineLiverHospitalAbnormalExaminationCruorDOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationTumourDO> getMedicineLiverHospitalAbnormalExaminationTumourDOS() {
        return medicineLiverHospitalAbnormalExaminationTumourDOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationTumourDOS(List<MedicineLiverHospitalAbnormalExaminationTumourDO> medicineLiverHospitalAbnormalExaminationTumourDOS) {
        this.medicineLiverHospitalAbnormalExaminationTumourDOS = medicineLiverHospitalAbnormalExaminationTumourDOS;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
