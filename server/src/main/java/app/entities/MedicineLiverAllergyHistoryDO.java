package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_allergy_history")
public class MedicineLiverAllergyHistoryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int allergyHistory;//既往过敏史
    @OneToMany(mappedBy = "medicineLiverAllergyHistoryDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverAllergyHistoryDetailDO> medicineLiverAllergyHistoryDetailDOS;
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

    public List<MedicineLiverAllergyHistoryDetailDO> getMedicineLiverAllergyHistoryDetailDOS() {
        return medicineLiverAllergyHistoryDetailDOS;
    }

    public void setMedicineLiverAllergyHistoryDetailDOS(List<MedicineLiverAllergyHistoryDetailDO> medicineLiverAllergyHistoryDetailDOS) {
        this.medicineLiverAllergyHistoryDetailDOS = medicineLiverAllergyHistoryDetailDOS;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
