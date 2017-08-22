package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hai")
public class HaiDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date addDate;
    private int patientId;
    private int portalAreaInflammation;// 门脉区炎症
    private int lobularMobility;// 小叶内活动度
    private int interfaceInflammation;// 界面炎
    private boolean choose;
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

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
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

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

}
