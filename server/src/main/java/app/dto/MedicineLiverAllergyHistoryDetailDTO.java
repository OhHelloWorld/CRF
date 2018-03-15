package app.dto;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class MedicineLiverAllergyHistoryDetailDTO {

    private int id;
    private int medicineLiverAllergyHistoryId;
    private String allergen;//过敏原
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicineLiverAllergyHistoryId() {
        return medicineLiverAllergyHistoryId;
    }

    public void setMedicineLiverAllergyHistoryId(int medicineLiverAllergyHistoryId) {
        this.medicineLiverAllergyHistoryId = medicineLiverAllergyHistoryId;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
