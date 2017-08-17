package app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bone_density")
public class BoneDensityDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private Date measuringTime;// 检测时间
    private Float lumbarSpine;// 腰椎
    @Column(name = "lumbar_spine_t")
    private int lumbarSpineT;// 腰椎T值
    private Float femoralNeck;// 股骨颈
    @Column(name = "femoral_neck_t")
    private int femoralNeckT;// 股骨颈T值
    private Float bigTrochanter;// 大粗隆
    @Column(name = "big_trochanter_t")
    private int bigTrochanterT;// 大粗隆T值
    private Float fullHip;// 全髋
    @Column(name = "full_hip_t")
    private int fullHipT;// 全髋T值
    private int diagnosis;// 诊断
    private String remarks;// 备注
    private boolean complete;
    private boolean followUp;// 是否为随访
    private Date followUpDate;// 随访时间


    public int getLumbarSpineT() {
        return lumbarSpineT;
    }

    public void setLumbarSpineT(int lumbarSpineT) {
        this.lumbarSpineT = lumbarSpineT;
    }

    public int getFemoralNeckT() {
        return femoralNeckT;
    }

    public void setFemoralNeckT(int femoralNeckT) {
        this.femoralNeckT = femoralNeckT;
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

    public Float getLumbarSpine() {
        return lumbarSpine;
    }

    public void setLumbarSpine(Float lumbarSpine) {
        this.lumbarSpine = lumbarSpine;
    }

    public Float getFemoralNeck() {
        return femoralNeck;
    }

    public void setFemoralNeck(Float femoralNeck) {
        this.femoralNeck = femoralNeck;
    }

    public Float getBigTrochanter() {
        return bigTrochanter;
    }

    public void setBigTrochanter(Float bigTrochanter) {
        this.bigTrochanter = bigTrochanter;
    }

    public Float getFullHip() {
        return fullHip;
    }

    public void setFullHip(Float fullHip) {
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
