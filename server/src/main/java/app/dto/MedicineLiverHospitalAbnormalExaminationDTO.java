package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverHospitalAbnormalExaminationDTO {

    private int id;
    private int patientId;
    private List<MedicineLiverHospitalAbnormalExaminationLiverDTO> medicineLiverHospitalAbnormalExaminationLiverDTOS;
    private List<MedicineLiverHospitalAbnormalExaminationKidneyDTO> medicineLiverHospitalAbnormalExaminationKidneyDTOS;
    private List<MedicineLiverHospitalAbnormalExaminationBsDTO> medicineLiverHospitalAbnormalExaminationBsDTOS;
    private List<MedicineLiverHospitalAbnormalExaminationCruorDTO> medicineLiverHospitalAbnormalExaminationCruorDTOS;
    private List<MedicineLiverHospitalAbnormalExaminationTumourDTO> medicineLiverHospitalAbnormalExaminationTumourDTOS;


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

    public List<MedicineLiverHospitalAbnormalExaminationLiverDTO> getMedicineLiverHospitalAbnormalExaminationLiverDTOS() {
        return medicineLiverHospitalAbnormalExaminationLiverDTOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationLiverDTOS(List<MedicineLiverHospitalAbnormalExaminationLiverDTO> medicineLiverHospitalAbnormalExaminationLiverDTOS) {
        this.medicineLiverHospitalAbnormalExaminationLiverDTOS = medicineLiverHospitalAbnormalExaminationLiverDTOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationKidneyDTO> getMedicineLiverHospitalAbnormalExaminationKidneyDTOS() {
        return medicineLiverHospitalAbnormalExaminationKidneyDTOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationKidneyDTOS(List<MedicineLiverHospitalAbnormalExaminationKidneyDTO> medicineLiverHospitalAbnormalExaminationKidneyDTOS) {
        this.medicineLiverHospitalAbnormalExaminationKidneyDTOS = medicineLiverHospitalAbnormalExaminationKidneyDTOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationBsDTO> getMedicineLiverHospitalAbnormalExaminationBsDTOS() {
        return medicineLiverHospitalAbnormalExaminationBsDTOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationBsDTOS(List<MedicineLiverHospitalAbnormalExaminationBsDTO> medicineLiverHospitalAbnormalExaminationBsDTOS) {
        this.medicineLiverHospitalAbnormalExaminationBsDTOS = medicineLiverHospitalAbnormalExaminationBsDTOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationCruorDTO> getMedicineLiverHospitalAbnormalExaminationCruorDTOS() {
        return medicineLiverHospitalAbnormalExaminationCruorDTOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationCruorDTOS(List<MedicineLiverHospitalAbnormalExaminationCruorDTO> medicineLiverHospitalAbnormalExaminationCruorDTOS) {
        this.medicineLiverHospitalAbnormalExaminationCruorDTOS = medicineLiverHospitalAbnormalExaminationCruorDTOS;
    }

    public List<MedicineLiverHospitalAbnormalExaminationTumourDTO> getMedicineLiverHospitalAbnormalExaminationTumourDTOS() {
        return medicineLiverHospitalAbnormalExaminationTumourDTOS;
    }

    public void setMedicineLiverHospitalAbnormalExaminationTumourDTOS(List<MedicineLiverHospitalAbnormalExaminationTumourDTO> medicineLiverHospitalAbnormalExaminationTumourDTOS) {
        this.medicineLiverHospitalAbnormalExaminationTumourDTOS = medicineLiverHospitalAbnormalExaminationTumourDTOS;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
