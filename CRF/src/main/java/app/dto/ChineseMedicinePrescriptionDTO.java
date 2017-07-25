package app.dto;

import java.util.Date;

public class ChineseMedicinePrescriptionDTO {

    private int id;
    private int patientId;
    private Date chineseMedicineTime;
    private String chineseMedicineFormulasDose;
    private String chineseMedicineHeal;
    private Date aProprietaryMedicineTime;
    private String aProprietaryMedicineName;
    private String aProprietaryMedicineHeal;
    private Date bProprietaryMedicineTime;
    private String bProprietaryMedicineName;
    private String bProprietaryMedicineHeal;
    private boolean complete;
    private boolean followUp;
    private Date followUpDate;

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

    public Date getChineseMedicineTime() {
        return chineseMedicineTime;
    }

    public void setChineseMedicineTime(Date chineseMedicineTime) {
        this.chineseMedicineTime = chineseMedicineTime;
    }

    public String getChineseMedicineFormulasDose() {
        return chineseMedicineFormulasDose;
    }

    public void setChineseMedicineFormulasDose(String chineseMedicineFormulasDose) {
        this.chineseMedicineFormulasDose = chineseMedicineFormulasDose;
    }

    public String getChineseMedicineHeal() {
        return chineseMedicineHeal;
    }

    public void setChineseMedicineHeal(String chineseMedicineHeal) {
        this.chineseMedicineHeal = chineseMedicineHeal;
    }

    public Date getaProprietaryMedicineTime() {
        return aProprietaryMedicineTime;
    }

    public void setaProprietaryMedicineTime(Date aProprietaryMedicineTime) {
        this.aProprietaryMedicineTime = aProprietaryMedicineTime;
    }

    public String getaProprietaryMedicineName() {
        return aProprietaryMedicineName;
    }

    public void setaProprietaryMedicineName(String aProprietaryMedicineName) {
        this.aProprietaryMedicineName = aProprietaryMedicineName;
    }

    public String getaProprietaryMedicineHeal() {
        return aProprietaryMedicineHeal;
    }

    public void setaProprietaryMedicineHeal(String aProprietaryMedicineHeal) {
        this.aProprietaryMedicineHeal = aProprietaryMedicineHeal;
    }

    public Date getbProprietaryMedicineTime() {
        return bProprietaryMedicineTime;
    }

    public void setbProprietaryMedicineTime(Date bProprietaryMedicineTime) {
        this.bProprietaryMedicineTime = bProprietaryMedicineTime;
    }

    public String getbProprietaryMedicineName() {
        return bProprietaryMedicineName;
    }

    public void setbProprietaryMedicineName(String bProprietaryMedicineName) {
        this.bProprietaryMedicineName = bProprietaryMedicineName;
    }

    public String getbProprietaryMedicineHeal() {
        return bProprietaryMedicineHeal;
    }

    public void setbProprietaryMedicineHeal(String bProprietaryMedicineHeal) {
        this.bProprietaryMedicineHeal = bProprietaryMedicineHeal;
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
