package app.dto;

import java.util.Date;

public class BoneDensityDTO {

    private int id;
    private int patientId;
    private Date measuringTime;
    private float lumbarSpine;
    private int lumbarSpineT;
    private float femoralNeck;
    private int femoralNeckT;
    private float bigTrochanter;
    private int bigTrochanterT;
    private float fullHip;
    private int fullHipT;
    private int diagnosis;
    private String remarks;
    private boolean complete;
    private boolean followUp;
    private Date followUpDate;

    public int getLumbarSpineT() {
        return lumbarSpineT;
    }

    public void setLumbarSpineT(int lumbarSpineT) {
        this.lumbarSpineT = lumbarSpineT;
    }

    public int getFemoralNeckT() {
        return femoralNeckT;
    }

    public void setFemoralNeckT(int femoraNeckT) {
        this.femoralNeckT = femoraNeckT;
    }

    public int getBigTrochanterT() {
        return bigTrochanterT;
    }

    public void setBigTrochanterT(int bigTrochanterT) {
        this.bigTrochanterT = bigTrochanterT;
    }

    public int getFullHipT() {
        return fullHipT;
    }

    public void setFullHipT(int fullHipT) {
        this.fullHipT = fullHipT;
    }


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

    public Date getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(Date measuringTime) {
        this.measuringTime = measuringTime;
    }

    public float getLumbarSpine() {
        return lumbarSpine;
    }

    public void setLumbarSpine(float lumbarSpine) {
        this.lumbarSpine = lumbarSpine;
    }

    public float getFemoralNeck() {
        return femoralNeck;
    }

    public void setFemoralNeck(float femoralNeck) {
        this.femoralNeck = femoralNeck;
    }

    public float getBigTrochanter() {
        return bigTrochanter;
    }

    public void setBigTrochanter(float bigTrochanter) {
        this.bigTrochanter = bigTrochanter;
    }

    public float getFullHip() {
        return fullHip;
    }

    public void setFullHip(float fullHip) {
        this.fullHip = fullHip;
    }

    public int getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(int diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

}
