package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_drink")
public class MedicineLiverDrinkDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int drinkHistory;//饮酒史
    private boolean complete;
    @OneToMany(mappedBy = "medicineLiverDrinkDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverDrinkDetailDO> medicineLiverDrinkDetailDOS;

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

    public List<MedicineLiverDrinkDetailDO> getMedicineLiverDrinkDetailDOS() {
        return medicineLiverDrinkDetailDOS;
    }

    public void setMedicineLiverDrinkDetailDOS(List<MedicineLiverDrinkDetailDO> medicineLiverDrinkDetailDOS) {
        this.medicineLiverDrinkDetailDOS = medicineLiverDrinkDetailDOS;
    }
}
