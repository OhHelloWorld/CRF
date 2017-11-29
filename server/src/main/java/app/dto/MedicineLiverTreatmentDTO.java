package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverTreatmentDTO {

    private int id;
    private int patientId;
    private int treatment;//治疗措施
    private boolean complete;
    private List<MedicineLiverTreatmentDetailDTO> medicineLiverTreatmentDetailDTOS;
    private List<MedicineLiverTreatmentOtherDTO> medicineLiverTreatmentOtherDTOS;
    private List<MedicineLiverTreatmentCnDTO> medicineLiverTreatmentCnDTOS;

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

    public List<MedicineLiverTreatmentDetailDTO> getMedicineLiverTreatmentDetailDTOS() {
        return medicineLiverTreatmentDetailDTOS;
    }

    public void setMedicineLiverTreatmentDetailDTOS(List<MedicineLiverTreatmentDetailDTO> medicineLiverTreatmentDetailDTOS) {
        this.medicineLiverTreatmentDetailDTOS = medicineLiverTreatmentDetailDTOS;
    }

    public List<MedicineLiverTreatmentOtherDTO> getMedicineLiverTreatmentOtherDTOS() {
        return medicineLiverTreatmentOtherDTOS;
    }

    public void setMedicineLiverTreatmentOtherDTOS(List<MedicineLiverTreatmentOtherDTO> medicineLiverTreatmentOtherDTOS) {
        this.medicineLiverTreatmentOtherDTOS = medicineLiverTreatmentOtherDTOS;
    }

    public List<MedicineLiverTreatmentCnDTO> getMedicineLiverTreatmentCnDTOS() {
        return medicineLiverTreatmentCnDTOS;
    }

    public void setMedicineLiverTreatmentCnDTOS(List<MedicineLiverTreatmentCnDTO> medicineLiverTreatmentCnDTOS) {
        this.medicineLiverTreatmentCnDTOS = medicineLiverTreatmentCnDTOS;
    }
}
