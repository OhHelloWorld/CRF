package app.dto;

import java.util.Date;

public class HaiDTO {

    private int id;
    private Date addDate;
    private int patientId;
    private int portalAreaInflammation;
    private int lobularMobility;
    private int interfaceInflammation;
    private boolean complete;
    private boolean choose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public int getPortalAreaInflammation() {
        return portalAreaInflammation;
    }

    public void setPortalAreaInflammation(int portalAreaInflammation) {
        this.portalAreaInflammation = portalAreaInflammation;
    }

    public int getLobularMobility() {
        return lobularMobility;
    }

    public void setLobularMobility(int lobularMobility) {
        this.lobularMobility = lobularMobility;
    }

    public int getInterfaceInflammation() {
        return interfaceInflammation;
    }

    public void setInterfaceInflammation(int interfaceInflammation) {
        this.interfaceInflammation = interfaceInflammation;
    }

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }


}
