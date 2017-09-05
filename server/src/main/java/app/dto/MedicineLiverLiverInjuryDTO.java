package app.dto;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverLiverInjuryDTO {

    private int id;
    private int patientId;
    private int ascites;//腹水
    private int hepaticEncephalopathy;//肝性脑病
    private int extendInr;//延长INR或者凝血时间
    private int failure;//器官衰竭
    private int extendHospitalStay;//住院时间延长
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
