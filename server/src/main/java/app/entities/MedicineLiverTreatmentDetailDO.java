//package app.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * Created by Administrator on 2017/8/24 0024.
// */
//@Entity(name = "medicine_liver_treatment_detail")
//public class MedicineLiverTreatmentDetailDO {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "medicine_liver_treatment_id")
//    private MedicineLiverTreatmentDO medicineLiverTreatmentDO;
//    private String genericName;//通用名
//    private String tradeName;//商品名
//    private String method;//用药方法
//    private String dose;//日剂量
//    private Date startDate;//开始日期
//    private Date endDate;//结束日期
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public MedicineLiverTreatmentDO getMedicineLiverTreatmentDO() {
//        return medicineLiverTreatmentDO;
//    }
//
//    public void setMedicineLiverTreatmentDO(MedicineLiverTreatmentDO medicineLiverTreatmentDO) {
//        this.medicineLiverTreatmentDO = medicineLiverTreatmentDO;
//    }
//
//    public String getGenericName() {
//        return genericName;
//    }
//
//    public void setGenericName(String genericName) {
//        this.genericName = genericName;
//    }
//
//    public String getTradeName() {
//        return tradeName;
//    }
//
//    public void setTradeName(String tradeName) {
//        this.tradeName = tradeName;
//    }
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public String getDose() {
//        return dose;
//    }
//
//    public void setDose(String dose) {
//        this.dose = dose;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//}
