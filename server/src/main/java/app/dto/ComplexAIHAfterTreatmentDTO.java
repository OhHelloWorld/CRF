package app.dto;

public class ComplexAIHAfterTreatmentDTO {

    private int id;
    private int patientId;
    private int woman;
    private int historyDrugs;
    private int aLPAST;
    private int alcoholIntake;
    private int serumGlobulinNormal;
    private int liverCheck;
    private int ana;
    private int otherImmuneDiseases;
    private int amaPositive;
    private int otherAvailableParameters;
    private int hepatitisVirusMarkers;
    private int responseTreatment;
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

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    public int getHistoryDrugs() {
        return historyDrugs;
    }

    public void setHistoryDrugs(int historyDrugs) {
        this.historyDrugs = historyDrugs;
    }

    public int getaLPAST() {
        return aLPAST;
    }

    public void setaLPAST(int aLPAST) {
        this.aLPAST = aLPAST;
    }

    public int getAlcoholIntake() {
        return alcoholIntake;
    }

    public void setAlcoholIntake(int alcoholIntake) {
        this.alcoholIntake = alcoholIntake;
    }

    public int getSerumGlobulinNormal() {
        return serumGlobulinNormal;
    }

    public void setSerumGlobulinNormal(int serumGlobulinNormal) {
        this.serumGlobulinNormal = serumGlobulinNormal;
    }

    public int getLiverCheck() {
        return liverCheck;
    }

    public void setLiverCheck(int liverCheck) {
        this.liverCheck = liverCheck;
    }

    public int getAna() {
        return ana;
    }

    public void setAna(int ana) {
        this.ana = ana;
    }

    public int getOtherImmuneDiseases() {
        return otherImmuneDiseases;
    }

    public void setOtherImmuneDiseases(int otherImmuneDiseases) {
        this.otherImmuneDiseases = otherImmuneDiseases;
    }

    public int getAmaPositive() {
        return amaPositive;
    }

    public void setAmaPositive(int amaPositive) {
        this.amaPositive = amaPositive;
    }

    public int getOtherAvailableParameters() {
        return otherAvailableParameters;
    }

    public void setOtherAvailableParameters(int otherAvailableParameters) {
        this.otherAvailableParameters = otherAvailableParameters;
    }

    public int getHepatitisVirusMarkers() {
        return hepatitisVirusMarkers;
    }

    public void setHepatitisVirusMarkers(int hepatitisVirusMarkers) {
        this.hepatitisVirusMarkers = hepatitisVirusMarkers;
    }

    public int getResponseTreatment() {
        return responseTreatment;
    }

    public void setResponseTreatment(int responseTreatment) {
        this.responseTreatment = responseTreatment;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
