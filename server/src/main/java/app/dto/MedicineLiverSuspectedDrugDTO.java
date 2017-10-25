package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverSuspectedDrugDTO {
    private int id;
    private int patientId;
    private boolean complete;
    private List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS;
    private List<MlProprietaryChineseMedicineDTO> mlProprietaryChineseMedicineDTOS;
    private List<MlChineseHerbalMedicineDTO> mlChineseHerbalMedicineDTOS;
    private List<MlSuspendChineseMedicineDTO> mlSuspendChineseMedicineDTOS;

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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverSuspectedDrugDetailDTO> getMedicineLiverSuspectedDrugDetailDTOS() {
        return medicineLiverSuspectedDrugDetailDTOS;
    }

    public void setMedicineLiverSuspectedDrugDetailDTOS(List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS) {
        this.medicineLiverSuspectedDrugDetailDTOS = medicineLiverSuspectedDrugDetailDTOS;
    }

    public List<MlProprietaryChineseMedicineDTO> getMlProprietaryChineseMedicineDTOS() {
        return mlProprietaryChineseMedicineDTOS;
    }

    public void setMlProprietaryChineseMedicineDTOS(List<MlProprietaryChineseMedicineDTO> mlProprietaryChineseMedicineDTOS) {
        this.mlProprietaryChineseMedicineDTOS = mlProprietaryChineseMedicineDTOS;
    }

    public List<MlChineseHerbalMedicineDTO> getMlChineseHerbalMedicineDTOS() {
        return mlChineseHerbalMedicineDTOS;
    }

    public void setMlChineseHerbalMedicineDTOS(List<MlChineseHerbalMedicineDTO> mlChineseHerbalMedicineDTOS) {
        this.mlChineseHerbalMedicineDTOS = mlChineseHerbalMedicineDTOS;
    }

    public List<MlSuspendChineseMedicineDTO> getMlSuspendChineseMedicineDTOS() {
        return mlSuspendChineseMedicineDTOS;
    }

    public void setMlSuspendChineseMedicineDTOS(List<MlSuspendChineseMedicineDTO> mlSuspendChineseMedicineDTOS) {
        this.mlSuspendChineseMedicineDTOS = mlSuspendChineseMedicineDTOS;
    }
}
