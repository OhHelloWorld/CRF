package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ishak")
public class IshakDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date addDate;
    private int patientId;
    private int portalAreaInflammation;// 门脉区炎症
    private int lobularMobility;// 小叶内活动度
    private int interfaceInflammation;// 界面炎
    private int confluentNecrosis;// 融合性坏死
    private int fibrosis;// 纤维化
    private boolean choose;// 是否选择
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date adDate) {
        this.addDate = adDate;
    }

    public int getPortalAreaInflammation() {
        return portalAreaInflammation;
    }

    public void setPortalAreaInflammation(int portalAreaInflammation) {
        this.portalAreaInflammation = portalAreaInflammation;
    }

    public int getLobularMobility() {
        return lobularMobility;
    }

    public void setLobularMobility(int lobularMobility) {
        this.lobularMobility = lobularMobility;
    }

    public int getInterfaceInflammation() {
        return interfaceInflammation;
    }

    public void setInterfaceInflammation(int interfaceInflammation) {
        this.interfaceInflammation = interfaceInflammation;
    }

    public int getConfluentNecrosis() {
        return confluentNecrosis;
    }

    public void setConfluentNecrosis(int confluentNecrosis) {
        this.confluentNecrosis = confluentNecrosis;
    }

    public int getFibrosis() {
        return fibrosis;
    }

    public void setFibrosis(int fibrosis) {
        this.fibrosis = fibrosis;
    }

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }
}
