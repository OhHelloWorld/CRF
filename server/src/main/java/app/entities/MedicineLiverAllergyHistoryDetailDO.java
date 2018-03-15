package app.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
@Entity(name = "medicine_liver_allergy_history_detail")
public class MedicineLiverAllergyHistoryDetailDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "allergy_history_id")
    private MedicineLiverAllergyHistoryDO medicineLiverAllergyHistoryDO;
    private String allergen;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverAllergyHistoryDO getMedicineLiverAllergyHistoryDO() {
        return medicineLiverAllergyHistoryDO;
    }

    public void setMedicineLiverAllergyHistoryDO(MedicineLiverAllergyHistoryDO medicineLiverAllergyHistoryDO) {
        this.medicineLiverAllergyHistoryDO = medicineLiverAllergyHistoryDO;
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
