package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverAllergyHistoryDTO {

    private int id;
    private int patientId;
    private int allergyHistory;//既往过敏史
    private List<MedicineLiverAllergyHistoryDetailDTO> medicineLiverAllergyHistoryDetailDTOS;
    private boolean complete;


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

    public int getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(int allergyHistory) {
        this.allergyHistory = allergyHistory;
    }

    public List<MedicineLiverAllergyHistoryDetailDTO> getMedicineLiverAllergyHistoryDetailDTOS() {
        return medicineLiverAllergyHistoryDetailDTOS;
    }

    public void setMedicineLiverAllergyHistoryDetailDTOS(List<MedicineLiverAllergyHistoryDetailDTO> medicineLiverAllergyHistoryDetailDTOS) {
        this.medicineLiverAllergyHistoryDetailDTOS = medicineLiverAllergyHistoryDetailDTOS;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
