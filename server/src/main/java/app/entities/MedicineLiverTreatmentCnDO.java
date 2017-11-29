package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
@Entity(name = "medicine_liver_treatment_cn")
public class MedicineLiverTreatmentCnDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "medicine_liver_treatment_id")
    private MedicineLiverTreatmentDO medicineLiverTreatmentDO;
    @Column(name = "cn_trade_name")
    private String cnTradeName;
    private String cnMethod;
    private String cnDose;
    @Column(name = "cn_start_date")
    private Date cnStartDate;
    @Column(name = "cn_end_date")
    private Date cnEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnTradeName() {
        return cnTradeName;
    }

    public void setCnTradeName(String cnTradeName) {
        this.cnTradeName = cnTradeName;
    }

    public String getCnMethod() {
        return cnMethod;
    }

    public void setCnMethod(String cnMethod) {
        this.cnMethod = cnMethod;
    }

    public String getCnDose() {
        return cnDose;
    }

    public void setCnDose(String cnDose) {
        this.cnDose = cnDose;
    }

    public Date getCnStartDate() {
        return cnStartDate;
    }

    public void setCnStartDate(Date cnStartDate) {
        this.cnStartDate = cnStartDate;
    }

    public Date getCnEndDate() {
        return cnEndDate;
    }

    public void setCnEndDate(Date cnEndDate) {
        this.cnEndDate = cnEndDate;
    }

    public MedicineLiverTreatmentDO getMedicineLiverTreatmentDO() {
        return medicineLiverTreatmentDO;
    }

    public void setMedicineLiverTreatmentDO(MedicineLiverTreatmentDO medicineLiverTreatmentDO) {
        this.medicineLiverTreatmentDO = medicineLiverTreatmentDO;
    }
}
