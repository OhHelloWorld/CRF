package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_treatment_other")
public class MedicineLiverTreatmentOtherDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "medicine_liver_treatment_id")
    private MedicineLiverTreatmentDO medicineLiverTreatmentDO;
    private String method;//治疗措施
    private String methodDetail;//治疗措施详述
    @Column(name = "other_start_date")
    private Date otherStartDate;//开始日期
    @Column(name = "other_end_date")
    private Date otherEndDate;//结束日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverTreatmentDO getMedicineLiverTreatmentDO() {
        return medicineLiverTreatmentDO;
    }

    public void setMedicineLiverTreatmentDO(MedicineLiverTreatmentDO medicineLiverTreatmentDO) {
        this.medicineLiverTreatmentDO = medicineLiverTreatmentDO;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodDetail() {
        return methodDetail;
    }

    public void setMethodDetail(String methodDetail) {
        this.methodDetail = methodDetail;
    }

    public Date getOtherStartDate() {
        return otherStartDate;
    }

    public void setOtherStartDate(Date otherStartDate) {
        this.otherStartDate = otherStartDate;
    }

    public Date getOtherEndDate() {
        return otherEndDate;
    }

    public void setOtherEndDate(Date otherEndDate) {
        this.otherEndDate = otherEndDate;
    }
}
