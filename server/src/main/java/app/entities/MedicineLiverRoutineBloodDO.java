//package app.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * Created by Administrator on 2017/8/24 0024.
// */
//@Entity(name = "medicine_liver_routine_blood")
//public class MedicineLiverRoutineBloodDO {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private int patientId;
//    private String wbc;
//    private Date wbcDate;
//    private String plt;
//    private Date pltDate;
//    private String hb;
//    private Date hbDate;
//    private String neutrophil;//中性粒细胞计数
//    private Date neutrophilDate;//中性粒细胞计数日期
//    private String totalHemoglobin;//总血红蛋白浓度
//    @Column(name = "total_hemoglobin_date")
//    private Date total_hemoglobin_date;//总血红蛋白浓度日期
//    private String eosinophil;//嗜酸性粒细胞计数
//    private Date eosinophilDate;//嗜酸性粒细胞计数日期
//    private String remark;//备注
//    private boolean complete;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(int patientId) {
//        this.patientId = patientId;
//    }
//
//    public String getWbc() {
//        return wbc;
//    }
//
//    public void setWbc(String wbc) {
//        this.wbc = wbc;
//    }
//
//    public Date getWbcDate() {
//        return wbcDate;
//    }
//
//    public void setWbcDate(Date wbcDate) {
//        this.wbcDate = wbcDate;
//    }
//
//    public String getPlt() {
//        return plt;
//    }
//
//    public void setPlt(String plt) {
//        this.plt = plt;
//    }
//
//    public Date getPltDate() {
//        return pltDate;
//    }
//
//    public void setPltDate(Date pltDate) {
//        this.pltDate = pltDate;
//    }
//
//    public String getHb() {
//        return hb;
//    }
//
//    public void setHb(String hb) {
//        this.hb = hb;
//    }
//
//    public Date getHbDate() {
//        return hbDate;
//    }
//
//    public void setHbDate(Date hbDate) {
//        this.hbDate = hbDate;
//    }
//
//    public String getNeutrophil() {
//        return neutrophil;
//    }
//
//    public void setNeutrophil(String neutrophil) {
//        this.neutrophil = neutrophil;
//    }
//
//    public Date getNeutrophilDate() {
//        return neutrophilDate;
//    }
//
//    public void setNeutrophilDate(Date neutrophilDate) {
//        this.neutrophilDate = neutrophilDate;
//    }
//
//    public String getTotalHemoglobin() {
//        return totalHemoglobin;
//    }
//
//    public void setTotalHemoglobin(String totalHemoglobin) {
//        this.totalHemoglobin = totalHemoglobin;
//    }
//
//    public Date getTotal_hemoglobin_date() {
//        return total_hemoglobin_date;
//    }
//
//    public void setTotal_hemoglobin_date(Date total_hemoglobin_date) {
//        this.total_hemoglobin_date = total_hemoglobin_date;
//    }
//
//    public String getEosinophil() {
//        return eosinophil;
//    }
//
//    public void setEosinophil(String eosinophil) {
//        this.eosinophil = eosinophil;
//    }
//
//    public Date getEosinophilDate() {
//        return eosinophilDate;
//    }
//
//    public void setEosinophilDate(Date eosinophilDate) {
//        this.eosinophilDate = eosinophilDate;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
//
//    public boolean isComplete() {
//        return complete;
//    }
//
//    public void setComplete(boolean complete) {
//        this.complete = complete;
//    }
//}
