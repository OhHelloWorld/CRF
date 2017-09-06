//package app.entities;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Created by Administrator on 2017/8/23 0023.
// */
//@Entity(name = "medicine_liver_disease_history")
//public class MedicineLiverDiseaseHistoryDO{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private int patientId;
//    private int otherHistory;//是否存在因本次入院的其他疾病史
//    private int pastDisease;//既往病史
//    private boolean complete;
//    @OneToMany(mappedBy = "medicineLiverDiseaseHistoryDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<MedicineLiverDiseaseHistoryDetailDO> medicineLiverDiseaseHistoryDetailDOS;
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
//    public int getOtherHistory() {
//        return otherHistory;
//    }
//
//    public void setOtherHistory(int otherHistory) {
//        this.otherHistory = otherHistory;
//    }
//
//    public int getPastDisease() {
//        return pastDisease;
//    }
//
//    public void setPastDisease(int pastDisease) {
//        this.pastDisease = pastDisease;
//    }
//
//    public boolean isComplete() {
//        return complete;
//    }
//
//    public void setComplete(boolean complete) {
//        this.complete = complete;
//    }
//
//    public List<MedicineLiverDiseaseHistoryDetailDO> getMedicineLiverDiseaseHistoryDetailDOS() {
//        return medicineLiverDiseaseHistoryDetailDOS;
//    }
//
//    public void setMedicineLiverDiseaseHistoryDetailDOS(List<MedicineLiverDiseaseHistoryDetailDO> medicineLiverDiseaseHistoryDetailDOS) {
//        this.medicineLiverDiseaseHistoryDetailDOS = medicineLiverDiseaseHistoryDetailDOS;
//    }
//}
