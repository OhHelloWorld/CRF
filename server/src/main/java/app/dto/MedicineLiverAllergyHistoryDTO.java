package app.dto;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverAllergyHistoryDTO {

    private int id;
    private int patientId;
    private int allergyHistory;//既往过敏史
    private String allergen;//过敏原
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

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
