//package app.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * Created by Administrator on 2017/8/24 0024.
// */
//@Entity(name = "medicine_liver_liver_histological")
//public class MedicineLiverLiverHistologicalDO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private int patientId;
//    @Column(name = "liver_histological_result")
//    private String liverHistologicalResult;//检查结果
//    @Column(name = "liver_histological_date")
//    private Date liverHistologicalDate;//检查日期
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
//    public String getLiverHistologicalResult() {
//        return liverHistologicalResult;
//    }
//
//    public void setLiverHistologicalResult(String liverHistologicalResult) {
//        this.liverHistologicalResult = liverHistologicalResult;
//    }
//
//    public Date getLiverHistologicalDate() {
//        return liverHistologicalDate;
//    }
//
//    public void setLiverHistologicalDate(Date liverHistologicalDate) {
//        this.liverHistologicalDate = liverHistologicalDate;
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
