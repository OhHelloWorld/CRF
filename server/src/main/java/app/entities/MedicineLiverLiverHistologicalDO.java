package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_liver_histological")
public class MedicineLiverLiverHistologicalDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int interfaceHepatitis;
    private int confluentNecrosis;
    private int focal;
    private int portalInflammation;
    private int fibrosis;
    private String severity;
    private int done;
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

    public int getInterfaceHepatitis() {
        return interfaceHepatitis;
    }

    public void setInterfaceHepatitis(int interfaceHepatitis) {
        this.interfaceHepatitis = interfaceHepatitis;
    }

    public int getConfluentNecrosis() {
        return confluentNecrosis;
    }

    public void setConfluentNecrosis(int confluentNecrosis) {
        this.confluentNecrosis = confluentNecrosis;
    }

    public int getFocal() {
        return focal;
    }

    public void setFocal(int focal) {
        this.focal = focal;
    }

    public int getPortalInflammation() {
        return portalInflammation;
    }

    public void setPortalInflammation(int portalInflammation) {
        this.portalInflammation = portalInflammation;
    }

    public int getFibrosis() {
        return fibrosis;
    }

    public void setFibrosis(int fibrosis) {
        this.fibrosis = fibrosis;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
