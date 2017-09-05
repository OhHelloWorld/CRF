package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverDrinkDTO {

    private int id;
    private int patientId;
    private int drinkHistory;//饮酒史
    private boolean complete;
    private List<MedicineLiverDrinkDetailDTO> medicineLiverDrinkDetailDTOS;

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

    public int getDrinkHistory() {
        return drinkHistory;
    }

    public void setDrinkHistory(int drinkHistory) {
        this.drinkHistory = drinkHistory;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverDrinkDetailDTO> getMedicineLiverDrinkDetailDTOS() {
        return medicineLiverDrinkDetailDTOS;
    }

    public void setMedicineLiverDrinkDetailDTOS(List<MedicineLiverDrinkDetailDTO> medicineLiverDrinkDetailDTOS) {
        this.medicineLiverDrinkDetailDTOS = medicineLiverDrinkDetailDTOS;
    }
}
