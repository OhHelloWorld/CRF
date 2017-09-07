package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverTreatmentOtherDTO {

    private int id;
    private int medicineLiverTreatmentId;
    private String method;//治疗措施
    private String methodDetail;//治疗措施详述
    private Date otherStartDate;//开始日期
    private Date otherEndDate;//结束日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicineLiverTreatmentId() {
        return medicineLiverTreatmentId;
    }

    public void setMedicineLiverTreatmentId(int medicineLiverTreatmentId) {
        this.medicineLiverTreatmentId = medicineLiverTreatmentId;
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
