package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_treatment")
public class MedicineLiverTreatmentDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int treatment;//治疗措施
    private boolean complete;
    @OneToMany(mappedBy = "medicineLiverTreatmentDO",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<MedicineLiverTreatmentDetailDO> medicineLiverTreatmentDetailDOS;
    @OneToMany(mappedBy = "medicineLiverTreatmentDO",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<MedicineLiverTreatmentOtherDO> medicineLiverTreatmentOtherDOS;
    @OneToMany(mappedBy = "medicineLiverTreatmentDO",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<MedicineLiverTreatmentCnDO> medicineLiverTreatmentCnDOS;

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

    public int getTreatment() {
        return treatment;
    }

    public void setTreatment(int treatment) {
        this.treatment = treatment;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverTreatmentDetailDO> getMedicineLiverTreatmentDetailDOS() {
        return medicineLiverTreatmentDetailDOS;
    }

    public void setMedicineLiverTreatmentDetailDOS(List<MedicineLiverTreatmentDetailDO> medicineLiverTreatmentDetailDOS) {
        this.medicineLiverTreatmentDetailDOS = medicineLiverTreatmentDetailDOS;
    }

    public List<MedicineLiverTreatmentOtherDO> getMedicineLiverTreatmentOtherDOS() {
        return medicineLiverTreatmentOtherDOS;
    }

    public void setMedicineLiverTreatmentOtherDOS(List<MedicineLiverTreatmentOtherDO> medicineLiverTreatmentOtherDOS) {
        this.medicineLiverTreatmentOtherDOS = medicineLiverTreatmentOtherDOS;
    }

    public List<MedicineLiverTreatmentCnDO> getMedicineLiverTreatmentCnDOS() {
        return medicineLiverTreatmentCnDOS;
    }

    public void setMedicineLiverTreatmentCnDOS(List<MedicineLiverTreatmentCnDO> medicineLiverTreatmentCnDOS) {
        this.medicineLiverTreatmentCnDOS = medicineLiverTreatmentCnDOS;
    }
}
