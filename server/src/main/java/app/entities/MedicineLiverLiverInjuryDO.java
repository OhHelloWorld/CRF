package app.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_liver_injury")
public class MedicineLiverLiverInjuryDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int ascites;//腹水
    private int hepaticEncephalopathy;//肝性脑病
    private int extendInr;//延长INR或者凝血时间
    private int failure;//器官衰竭
    @Column(name = "extend_hospital_stay")
    private int extendHospitalStay;//住院时间延长
    private String medicine;
    private String alt;
    private String alp;
    private String r;
    @Column(name = "liver_injury_type")
    private String liverInjuryType;
    private int medicineStart;
    private int withdrawalStart;
    private int stopMedicine;
    private int continueMedicine;
    private int drinkPregnancy;
    private int age;
    private int withMedicine;
    @Column(name = "other_liver_injury_reason")
    private int otherLiverInjuryReason;
    @Column(name = "past_liver_injury_information")
    private int pastLiverInjuryInformation;
    @Column(name = "re_medicine_response")
    private int reMedicineResponse;
    private String rucam;//rucam评分
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

    public int getAscites() {
        return ascites;
    }

    public void setAscites(int ascites) {
        this.ascites = ascites;
    }

    public int getHepaticEncephalopathy() {
        return hepaticEncephalopathy;
    }

    public void setHepaticEncephalopathy(int hepaticEncephalopathy) {
        this.hepaticEncephalopathy = hepaticEncephalopathy;
    }

    public int getExtendInr() {
        return extendInr;
    }

    public void setExtendInr(int extendInr) {
        this.extendInr = extendInr;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public int getExtendHospitalStay() {
        return extendHospitalStay;
    }

    public void setExtendHospitalStay(int extendHospitalStay) {
        this.extendHospitalStay = extendHospitalStay;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAlp() {
        return alp;
    }

    public void setAlp(String alp) {
        this.alp = alp;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getLiverInjuryType() {
        return liverInjuryType;
    }

    public void setLiverInjuryType(String liverInjuryType) {
        this.liverInjuryType = liverInjuryType;
    }

    public int getMedicineStart() {
        return medicineStart;
    }

    public void setMedicineStart(int medicineStart) {
        this.medicineStart = medicineStart;
    }

    public int getWithdrawalStart() {
        return withdrawalStart;
    }

    public void setWithdrawalStart(int withdrawalStart) {
        this.withdrawalStart = withdrawalStart;
    }

    public int getStopMedicine() {
        return stopMedicine;
    }

    public void setStopMedicine(int stopMedicine) {
        this.stopMedicine = stopMedicine;
    }

    public int getContinueMedicine() {
        return continueMedicine;
    }

    public void setContinueMedicine(int continueMedicine) {
        this.continueMedicine = continueMedicine;
    }

    public int getDrinkPregnancy() {
        return drinkPregnancy;
    }

    public void setDrinkPregnancy(int drinkPregnancy) {
        this.drinkPregnancy = drinkPregnancy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWithMedicine() {
        return withMedicine;
    }

    public void setWithMedicine(int withMedicine) {
        this.withMedicine = withMedicine;
    }

    public int getOtherLiverInjuryReason() {
        return otherLiverInjuryReason;
    }

    public void setOtherLiverInjuryReason(int otherLiverInjuryReason) {
        this.otherLiverInjuryReason = otherLiverInjuryReason;
    }

    public int getPastLiverInjuryInformation() {
        return pastLiverInjuryInformation;
    }

    public void setPastLiverInjuryInformation(int pastLiverInjuryInformation) {
        this.pastLiverInjuryInformation = pastLiverInjuryInformation;
    }

    public int getReMedicineResponse() {
        return reMedicineResponse;
    }

    public void setReMedicineResponse(int reMedicineResponse) {
        this.reMedicineResponse = reMedicineResponse;
    }

    public String getRucam() {
        return rucam;
    }

    public void setRucam(String rucam) {
        this.rucam = rucam;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
