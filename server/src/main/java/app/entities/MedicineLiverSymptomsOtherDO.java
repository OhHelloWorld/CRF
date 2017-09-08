package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_symptoms_other")
public class MedicineLiverSymptomsOtherDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medicine_liver_symptoms_id")
    private MedicineLiverSymptomsDO medicineLiverSymptomsDO;
    private String name;//其他体征名
    private String description;//表现
    private Date beginDate;//出现时间
    private Date disappearDate;//消失时间
    private String dischargeSymptoms;//出院表现

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverSymptomsDO getMedicineLiverSymptomsDO() {
        return medicineLiverSymptomsDO;
    }

    public void setMedicineLiverSymptomsDO(MedicineLiverSymptomsDO medicineLiverSymptomsDO) {
        this.medicineLiverSymptomsDO = medicineLiverSymptomsDO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDischargeSymptoms() {
        return dischargeSymptoms;
    }

    public void setDischargeSymptoms(String dischargeSymptoms) {
        this.dischargeSymptoms = dischargeSymptoms;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getDisappearDate() {
        return disappearDate;
    }

    public void setDisappearDate(Date disappearDate) {
        this.disappearDate = disappearDate;
    }
}
