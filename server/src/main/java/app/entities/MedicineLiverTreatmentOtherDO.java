//package app.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * Created by Administrator on 2017/8/24 0024.
// */
//@Entity(name = "medicine_liver_treatment_other")
//public class MedicineLiverTreatmentOtherDO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "medicine_liver_treatment_id")
//    private MedicineLiverTreatmentDO medicineLiverTreatmentDO;
//    private String method;//治疗措施
//    private String methodDetail;//治疗措施详述
//    @Column(name = "detail_start_date")
//    private Date detailStartDate;//开始日期
//    @Column(name = "detail_end_date")
//    private Date detailEndDate;//结束日期
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
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public String getMethodDetail() {
//        return methodDetail;
//    }
//
//    public void setMethodDetail(String methodDetail) {
//        this.methodDetail = methodDetail;
//    }
//
//    public Date getDetailStartDate() {
//        return detailStartDate;
//    }
//
//    public void setDetailStartDate(Date detailStartDate) {
//        this.detailStartDate = detailStartDate;
//    }
//
//    public Date getDetailEndDate() {
//        return detailEndDate;
//    }
//
//    public void setDetailEndDate(Date detailEndDate) {
//        this.detailEndDate = detailEndDate;
//    }
//}
