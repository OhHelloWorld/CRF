package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverRoutineBloodDTO {

    private int id;
    private int patientId;
    private Date routineBloodDate;
    private String wbc;
    private String plt;
    private String hb;
    private String neutrophil;//中性粒细胞计数
    private String totalHemoglobin;//总血红蛋白浓度
    private String eosinophil;//嗜酸性粒细胞计数
    private String remark;//备注
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

    public String getWbc() {
        return wbc;
    }

    public void setWbc(String wbc) {
        this.wbc = wbc;
    }

    public String getPlt() {
        return plt;
    }

    public void setPlt(String plt) {
        this.plt = plt;
    }

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getNeutrophil() {
        return neutrophil;
    }

    public void setNeutrophil(String neutrophil) {
        this.neutrophil = neutrophil;
    }

    public String getTotalHemoglobin() {
        return totalHemoglobin;
    }

    public void setTotalHemoglobin(String totalHemoglobin) {
        this.totalHemoglobin = totalHemoglobin;
    }

    public String getEosinophil() {
        return eosinophil;
    }

    public void setEosinophil(String eosinophil) {
        this.eosinophil = eosinophil;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getRoutineBloodDate() {
        return routineBloodDate;
    }

    public void setRoutineBloodDate(Date routineBloodDate) {
        this.routineBloodDate = routineBloodDate;
    }
}
