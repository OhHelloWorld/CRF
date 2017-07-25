package app.dto;

public class FinalDiagnosisSpecialCircumstancesDTO {

    private int id;
    private int patientId;
    private String pbcClinicalStage;
    private String aihClinicalStage;
    private boolean children;
    private boolean gestationPeriod;
    private boolean repeatedRelapse;
    private boolean resistantToSteroidTreatment;
    private boolean patientsWithChronicHepatitisB;
    private boolean patientsWithChronicHepatitisC;
    private boolean overlappingAIHPBC;
    private boolean overlappingAIHPSC;
    private boolean autoimmuneCholangitis;
    private boolean finalDiagnosisOther;
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

    public String getPbcClinicalStage() {
        return pbcClinicalStage;
    }

    public void setPbcClinicalStage(String pbcClinicalStage) {
        this.pbcClinicalStage = pbcClinicalStage;
    }

    public String getAihClinicalStage() {
        return aihClinicalStage;
    }

    public void setAihClinicalStage(String aihClinicalStage) {
        this.aihClinicalStage = aihClinicalStage;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public boolean isGestationPeriod() {
        return gestationPeriod;
    }

    public void setGestationPeriod(boolean gestationPeriod) {
        this.gestationPeriod = gestationPeriod;
    }

    public boolean isRepeatedRelapse() {
        return repeatedRelapse;
    }

    public void setRepeatedRelapse(boolean repeatedRelapse) {
        this.repeatedRelapse = repeatedRelapse;
    }

    public boolean isResistantToSteroidTreatment() {
        return resistantToSteroidTreatment;
    }

    public void setResistantToSteroidTreatment(boolean resistantToSteroidTreatment) {
        this.resistantToSteroidTreatment = resistantToSteroidTreatment;
    }

    public boolean isPatientsWithChronicHepatitisB() {
        return patientsWithChronicHepatitisB;
    }

    public void setPatientsWithChronicHepatitisB(boolean patientsWithChronicHepatitisB) {
        this.patientsWithChronicHepatitisB = patientsWithChronicHepatitisB;
    }

    public boolean isPatientsWithChronicHepatitisC() {
        return patientsWithChronicHepatitisC;
    }

    public void setPatientsWithChronicHepatitisC(boolean patientsWithChronicHepatitisC) {
        this.patientsWithChronicHepatitisC = patientsWithChronicHepatitisC;
    }

    public boolean isOverlappingAIHPBC() {
        return overlappingAIHPBC;
    }

    public void setOverlappingAIHPBC(boolean overlappingAIHPBC) {
        this.overlappingAIHPBC = overlappingAIHPBC;
    }

    public boolean isOverlappingAIHPSC() {
        return overlappingAIHPSC;
    }

    public void setOverlappingAIHPSC(boolean overlappingAIHPSC) {
        this.overlappingAIHPSC = overlappingAIHPSC;
    }

    public boolean isAutoimmuneCholangitis() {
        return autoimmuneCholangitis;
    }

    public void setAutoimmuneCholangitis(boolean autoimmuneCholangitis) {
        this.autoimmuneCholangitis = autoimmuneCholangitis;
    }

    public boolean isFinalDiagnosisOther() {
        return finalDiagnosisOther;
    }

    public void setFinalDiagnosisOther(boolean finalDiagnosisOther) {
        this.finalDiagnosisOther = finalDiagnosisOther;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
