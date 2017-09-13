package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_disease_outcome")
public class MedicineLiverDiseaseOutcomeDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private String outcome;//疾病转归
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

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
