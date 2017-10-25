package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class MlChineseHerbalMedicineDTO {

    private int id;
    private int mlDrugId;
    private String herbalName;
    private String herbalDose;
    private Date herbalBeginTime;
    private Date herbalEndTime;
    private String buyFrom;
    private String herbalCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMlDrugId() {
        return mlDrugId;
    }

    public void setMlDrugId(int mlDrugId) {
        this.mlDrugId = mlDrugId;
    }

    public String getHerbalName() {
        return herbalName;
    }

    public void setHerbalName(String herbalName) {
        this.herbalName = herbalName;
    }

    public String getHerbalDose() {
        return herbalDose;
    }

    public void setHerbalDose(String herbalDose) {
        this.herbalDose = herbalDose;
    }

    public Date getHerbalBeginTime() {
        return herbalBeginTime;
    }

    public void setHerbalBeginTime(Date herbalBeginTime) {
        this.herbalBeginTime = herbalBeginTime;
    }

    public Date getHerbalEndTime() {
        return herbalEndTime;
    }

    public void setHerbalEndTime(Date herbalEndTime) {
        this.herbalEndTime = herbalEndTime;
    }

    public String getBuyFrom() {
        return buyFrom;
    }

    public void setBuyFrom(String buyFrom) {
        this.buyFrom = buyFrom;
    }

    public String getHerbalCategory() {
        return herbalCategory;
    }

    public void setHerbalCategory(String herbalCategory) {
        this.herbalCategory = herbalCategory;
    }
}
