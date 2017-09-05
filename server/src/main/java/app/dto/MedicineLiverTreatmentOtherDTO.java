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
    private Date startDate;//开始日期
    private Date endDate;//结束日期

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
