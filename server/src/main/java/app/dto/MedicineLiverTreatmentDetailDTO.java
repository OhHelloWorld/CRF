package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverTreatmentDetailDTO {

    private int id;
    private int medicineLiverTreatmentId;
    private String genericName;//通用名
    private String tradeName;//商品名
    private String detailMethod;//用药方法
    private String dose;//日剂量
    private Date detailStartDate;//开始日期
    private Date detailEndDate;//结束日期

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

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getDetailMethod() {
        return detailMethod;
    }

    public void setDetailMethod(String detailMethod) {
        this.detailMethod = detailMethod;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Date getDetailStartDate() {
        return detailStartDate;
    }

    public void setDetailStartDate(Date detailStartDate) {
        this.detailStartDate = detailStartDate;
    }

    public Date getDetailEndDate() {
        return detailEndDate;
    }

    public void setDetailEndDate(Date detailEndDate) {
        this.detailEndDate = detailEndDate;
    }
}
