package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverDiseaseHistoryDTO {
    private int id;
    private int patientId;
    private int otherHistory;//是否存在因本次入院的其他疾病史
    private int pastDisease;//既往病史
    private int epidemicTourism;
    private String epidemicText;
    private boolean complete;
    private List<MedicineLiverDiseaseHistoryDetailDTO> medicineLiverDiseaseHistoryDetailDTOS;

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

    public int getOtherHistory() {
        return otherHistory;
    }

    public void setOtherHistory(int otherHistory) {
        this.otherHistory = otherHistory;
    }

    public int getPastDisease() {
        return pastDisease;
    }

    public void setPastDisease(int pastDisease) {
        this.pastDisease = pastDisease;
    }

    public int getEpidemicTourism() {
        return epidemicTourism;
    }

    public void setEpidemicTourism(int epidemicTourism) {
        this.epidemicTourism = epidemicTourism;
    }

    public String getEpidemicText() {
        return epidemicText;
    }

    public void setEpidemicText(String epidemicText) {
        this.epidemicText = epidemicText;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverDiseaseHistoryDetailDTO> getMedicineLiverDiseaseHistoryDetailDTOS() {
        return medicineLiverDiseaseHistoryDetailDTOS;
    }

    public void setMedicineLiverDiseaseHistoryDetailDTOS(List<MedicineLiverDiseaseHistoryDetailDTO> medicineLiverDiseaseHistoryDetailDTOS) {
        this.medicineLiverDiseaseHistoryDetailDTOS = medicineLiverDiseaseHistoryDetailDTOS;
    }
}
