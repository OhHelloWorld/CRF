package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_treatment_detail")
public class MedicineLiverTreatmentDetailDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "medicine_liver_treatment_id")
    private MedicineLiverTreatmentDO medicineLiverTreatmentDO;
    private String genericName;//通用名
    private String tradeName;//商品名
    private String detailMethod;//用药方法
    private String category;
    private String dose;//日剂量
    @Column(name = "detail_start_date")
    private Date detailStartDate;//开始日期
    @Column(name = "detail_end_date")
    private Date detailEndDate;//结束日期

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
